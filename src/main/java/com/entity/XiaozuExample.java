package com.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Xiaozu
 * @Description mybatis持久层数据操作小组表搜索条件及排序封装扩展类
 */
public class XiaozuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XiaozuExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMingchengIsNull() {
            addCriterion("mingcheng is null");
            return (Criteria) this;
        }

        public Criteria andMingchengIsNotNull() {
            addCriterion("mingcheng is not null");
            return (Criteria) this;
        }

        public Criteria andMingchengEqualTo(String value) {
            addCriterion("mingcheng =", value, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengNotEqualTo(String value) {
            addCriterion("mingcheng <>", value, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengGreaterThan(String value) {
            addCriterion("mingcheng >", value, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengGreaterThanOrEqualTo(String value) {
            addCriterion("mingcheng >=", value, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengLessThan(String value) {
            addCriterion("mingcheng <", value, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengLessThanOrEqualTo(String value) {
            addCriterion("mingcheng <=", value, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengLike(String value) {
            addCriterion("mingcheng like", value, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengNotLike(String value) {
            addCriterion("mingcheng not like", value, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengIn(List<String> values) {
            addCriterion("mingcheng in", values, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengNotIn(List<String> values) {
            addCriterion("mingcheng not in", values, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengBetween(String value1, String value2) {
            addCriterion("mingcheng between", value1, value2, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengNotBetween(String value1, String value2) {
            addCriterion("mingcheng not between", value1, value2, "mingcheng");
            return (Criteria) this;
        }
        public Criteria andTupianIsNull() {
            addCriterion("tupian is null");
            return (Criteria) this;
        }

        public Criteria andTupianIsNotNull() {
            addCriterion("tupian is not null");
            return (Criteria) this;
        }

        public Criteria andTupianEqualTo(String value) {
            addCriterion("tupian =", value, "tupian");
            return (Criteria) this;
        }

        public Criteria andTupianNotEqualTo(String value) {
            addCriterion("tupian <>", value, "tupian");
            return (Criteria) this;
        }

        public Criteria andTupianGreaterThan(String value) {
            addCriterion("tupian >", value, "tupian");
            return (Criteria) this;
        }

        public Criteria andTupianGreaterThanOrEqualTo(String value) {
            addCriterion("tupian >=", value, "tupian");
            return (Criteria) this;
        }

        public Criteria andTupianLessThan(String value) {
            addCriterion("tupian <", value, "tupian");
            return (Criteria) this;
        }

        public Criteria andTupianLessThanOrEqualTo(String value) {
            addCriterion("tupian <=", value, "tupian");
            return (Criteria) this;
        }

        public Criteria andTupianLike(String value) {
            addCriterion("tupian like", value, "tupian");
            return (Criteria) this;
        }

        public Criteria andTupianNotLike(String value) {
            addCriterion("tupian not like", value, "tupian");
            return (Criteria) this;
        }

        public Criteria andTupianIn(List<String> values) {
            addCriterion("tupian in", values, "tupian");
            return (Criteria) this;
        }

        public Criteria andTupianNotIn(List<String> values) {
            addCriterion("tupian not in", values, "tupian");
            return (Criteria) this;
        }

        public Criteria andTupianBetween(String value1, String value2) {
            addCriterion("tupian between", value1, value2, "tupian");
            return (Criteria) this;
        }

        public Criteria andTupianNotBetween(String value1, String value2) {
            addCriterion("tupian not between", value1, value2, "tupian");
            return (Criteria) this;
        }
        public Criteria andHuodongidIsNull() {
            addCriterion("huodongid is null");
            return (Criteria) this;
        }

        public Criteria andHuodongidIsNotNull() {
            addCriterion("huodongid is not null");
            return (Criteria) this;
        }

        public Criteria andHuodongidEqualTo(Integer value) {
            addCriterion("huodongid =", value, "huodongid");
            return (Criteria) this;
        }

        public Criteria andHuodongidNotEqualTo(Integer value) {
            addCriterion("huodongid <>", value, "huodongid");
            return (Criteria) this;
        }

        public Criteria andHuodongidGreaterThan(Integer value) {
            addCriterion("huodongid >", value, "huodongid");
            return (Criteria) this;
        }

        public Criteria andHuodongidGreaterThanOrEqualTo(Integer value) {
            addCriterion("huodongid >=", value, "huodongid");
            return (Criteria) this;
        }

        public Criteria andHuodongidLessThan(Integer value) {
            addCriterion("huodongid <", value, "huodongid");
            return (Criteria) this;
        }

        public Criteria andHuodongidLessThanOrEqualTo(Integer value) {
            addCriterion("huodongid <=", value, "huodongid");
            return (Criteria) this;
        }

        public Criteria andHuodongidLike(Integer value) {
            addCriterion("huodongid like", value, "huodongid");
            return (Criteria) this;
        }

        public Criteria andHuodongidNotLike(Integer value) {
            addCriterion("huodongid not like", value, "huodongid");
            return (Criteria) this;
        }

        public Criteria andHuodongidIn(List<Integer> values) {
            addCriterion("huodongid in", values, "huodongid");
            return (Criteria) this;
        }

        public Criteria andHuodongidNotIn(List<Integer> values) {
            addCriterion("huodongid not in", values, "huodongid");
            return (Criteria) this;
        }

        public Criteria andHuodongidBetween(Integer value1, Integer value2) {
            addCriterion("huodongid between", value1, value2, "huodongid");
            return (Criteria) this;
        }

        public Criteria andHuodongidNotBetween(Integer value1, Integer value2) {
            addCriterion("huodongid not between", value1, value2, "huodongid");
            return (Criteria) this;
        }
        public Criteria andChengjiIsNull() {
            addCriterion("chengji is null");
            return (Criteria) this;
        }

        public Criteria andChengjiIsNotNull() {
            addCriterion("chengji is not null");
            return (Criteria) this;
        }

        public Criteria andChengjiEqualTo(Integer value) {
            addCriterion("chengji =", value, "chengji");
            return (Criteria) this;
        }

        public Criteria andChengjiNotEqualTo(Integer value) {
            addCriterion("chengji <>", value, "chengji");
            return (Criteria) this;
        }

        public Criteria andChengjiGreaterThan(Integer value) {
            addCriterion("chengji >", value, "chengji");
            return (Criteria) this;
        }

        public Criteria andChengjiGreaterThanOrEqualTo(Integer value) {
            addCriterion("chengji >=", value, "chengji");
            return (Criteria) this;
        }

        public Criteria andChengjiLessThan(Integer value) {
            addCriterion("chengji <", value, "chengji");
            return (Criteria) this;
        }

        public Criteria andChengjiLessThanOrEqualTo(Integer value) {
            addCriterion("chengji <=", value, "chengji");
            return (Criteria) this;
        }

        public Criteria andChengjiLike(Integer value) {
            addCriterion("chengji like", value, "chengji");
            return (Criteria) this;
        }

        public Criteria andChengjiNotLike(Integer value) {
            addCriterion("chengji not like", value, "chengji");
            return (Criteria) this;
        }

        public Criteria andChengjiIn(List<Integer> values) {
            addCriterion("chengji in", values, "chengji");
            return (Criteria) this;
        }

        public Criteria andChengjiNotIn(List<Integer> values) {
            addCriterion("chengji not in", values, "chengji");
            return (Criteria) this;
        }

        public Criteria andChengjiBetween(Integer value1, Integer value2) {
            addCriterion("chengji between", value1, value2, "chengji");
            return (Criteria) this;
        }

        public Criteria andChengjiNotBetween(Integer value1, Integer value2) {
            addCriterion("chengji not between", value1, value2, "chengji");
            return (Criteria) this;
        }
        public Criteria andUsersidIsNull() {
            addCriterion("usersid is null");
            return (Criteria) this;
        }

        public Criteria andUsersidIsNotNull() {
            addCriterion("usersid is not null");
            return (Criteria) this;
        }

        public Criteria andUsersidEqualTo(Integer value) {
            addCriterion("usersid =", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidNotEqualTo(Integer value) {
            addCriterion("usersid <>", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidGreaterThan(Integer value) {
            addCriterion("usersid >", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidGreaterThanOrEqualTo(Integer value) {
            addCriterion("usersid >=", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidLessThan(Integer value) {
            addCriterion("usersid <", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidLessThanOrEqualTo(Integer value) {
            addCriterion("usersid <=", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidLike(Integer value) {
            addCriterion("usersid like", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidNotLike(Integer value) {
            addCriterion("usersid not like", value, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidIn(List<Integer> values) {
            addCriterion("usersid in", values, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidNotIn(List<Integer> values) {
            addCriterion("usersid not in", values, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidBetween(Integer value1, Integer value2) {
            addCriterion("usersid between", value1, value2, "usersid");
            return (Criteria) this;
        }

        public Criteria andUsersidNotBetween(Integer value1, Integer value2) {
            addCriterion("usersid not between", value1, value2, "usersid");
            return (Criteria) this;
        }

    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
