package com.frame.boot.frame.core.search;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.frame.common.frame.base.enums.AndOr;
import org.springframework.data.jpa.domain.Specification;

import com.frame.boot.frame.core.exceptions.SearchException;

/**
 * 查询构建器
 * @author duancq
 * 2016年8月29日 下午2:55:05
 */
public class CriteriaBuilder<T> implements Specification<T> {

	private List<Criteria<T>> criterias = new ArrayList<>();
	private List<AndOr> conjunctions = new ArrayList<>();

	public CriteriaBuilder(Criteria<T> criteria) {
		criterias.add(criteria);
	}

	public CriteriaBuilder(List<Criteria<T>> criterias, List<AndOr> conjunctions) {
		this.criterias = criterias;
		this.conjunctions = conjunctions;
	}

	public CriteriaBuilder<T> and(Criteria<T> criteria) {
		criterias.add(criteria);
		conjunctions.add(AndOr.AND);
		return this;
	}

	public CriteriaBuilder<T> or(Criteria<T> criteria) {
		criterias.add(criteria);
		conjunctions.add(AndOr.OR);
		return this;
	}

	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, javax.persistence.criteria.CriteriaBuilder cb) {
		// 第一个
		Predicate tempPredicate = criterias.get(0).toPredicate(root, query, cb);

		// 多个的时候，进行处理
		int size = criterias.size();
		if (size >= 1) {
			for (int i = 1; i < size; i++) {
				Criteria<T> criteria = criterias.get(i);
				AndOr conjunction = conjunctions.get(i - 1);
				switch (conjunction) {
					case AND: tempPredicate = cb.and(tempPredicate, criteria.toPredicate(root, query, cb)); break;
					case OR: tempPredicate = cb.or(tempPredicate, criteria.toPredicate(root, query, cb)); break;
					default: throw new SearchException(SearchException.ERROR_CODE_CRITERIA_ERROR,
							String.format("AndOr not found. conjunction:%s", conjunction),
							SearchException.SHOW_MSG_CRITERIA_ERROR);
				}
			}
		}
		return tempPredicate;
	}

}
