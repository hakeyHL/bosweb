package com.bos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
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
            addCriterion("`id` is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("`id` is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("`id` =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("`id` <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("`id` >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("`id` >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("`id` <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("`id` <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("`id` in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("`id` not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("`id` between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("`id` not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSenderIsNull() {
            addCriterion("`sender` is null");
            return (Criteria) this;
        }

        public Criteria andSenderIsNotNull() {
            addCriterion("`sender` is not null");
            return (Criteria) this;
        }

        public Criteria andSenderEqualTo(String value) {
            addCriterion("`sender` =", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotEqualTo(String value) {
            addCriterion("`sender` <>", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThan(String value) {
            addCriterion("`sender` >", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThanOrEqualTo(String value) {
            addCriterion("`sender` >=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThan(String value) {
            addCriterion("`sender` <", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThanOrEqualTo(String value) {
            addCriterion("`sender` <=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLike(String value) {
            addCriterion("`sender` like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotLike(String value) {
            addCriterion("`sender` not like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderIn(List<String> values) {
            addCriterion("`sender` in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotIn(List<String> values) {
            addCriterion("`sender` not in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderBetween(String value1, String value2) {
            addCriterion("`sender` between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotBetween(String value1, String value2) {
            addCriterion("`sender` not between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNull() {
            addCriterion("`receiver` is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNotNull() {
            addCriterion("`receiver` is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverEqualTo(String value) {
            addCriterion("`receiver` =", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotEqualTo(String value) {
            addCriterion("`receiver` <>", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThan(String value) {
            addCriterion("`receiver` >", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThanOrEqualTo(String value) {
            addCriterion("`receiver` >=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThan(String value) {
            addCriterion("`receiver` <", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThanOrEqualTo(String value) {
            addCriterion("`receiver` <=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLike(String value) {
            addCriterion("`receiver` like", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotLike(String value) {
            addCriterion("`receiver` not like", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverIn(List<String> values) {
            addCriterion("`receiver` in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotIn(List<String> values) {
            addCriterion("`receiver` not in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverBetween(String value1, String value2) {
            addCriterion("`receiver` between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotBetween(String value1, String value2) {
            addCriterion("`receiver` not between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andSenderphoneIsNull() {
            addCriterion("`senderPhone` is null");
            return (Criteria) this;
        }

        public Criteria andSenderphoneIsNotNull() {
            addCriterion("`senderPhone` is not null");
            return (Criteria) this;
        }

        public Criteria andSenderphoneEqualTo(String value) {
            addCriterion("`senderPhone` =", value, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneNotEqualTo(String value) {
            addCriterion("`senderPhone` <>", value, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneGreaterThan(String value) {
            addCriterion("`senderPhone` >", value, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneGreaterThanOrEqualTo(String value) {
            addCriterion("`senderPhone` >=", value, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneLessThan(String value) {
            addCriterion("`senderPhone` <", value, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneLessThanOrEqualTo(String value) {
            addCriterion("`senderPhone` <=", value, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneLike(String value) {
            addCriterion("`senderPhone` like", value, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneNotLike(String value) {
            addCriterion("`senderPhone` not like", value, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneIn(List<String> values) {
            addCriterion("`senderPhone` in", values, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneNotIn(List<String> values) {
            addCriterion("`senderPhone` not in", values, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneBetween(String value1, String value2) {
            addCriterion("`senderPhone` between", value1, value2, "senderphone");
            return (Criteria) this;
        }

        public Criteria andSenderphoneNotBetween(String value1, String value2) {
            addCriterion("`senderPhone` not between", value1, value2, "senderphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneIsNull() {
            addCriterion("`receiverPhone` is null");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneIsNotNull() {
            addCriterion("`receiverPhone` is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneEqualTo(String value) {
            addCriterion("`receiverPhone` =", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneNotEqualTo(String value) {
            addCriterion("`receiverPhone` <>", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneGreaterThan(String value) {
            addCriterion("`receiverPhone` >", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneGreaterThanOrEqualTo(String value) {
            addCriterion("`receiverPhone` >=", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneLessThan(String value) {
            addCriterion("`receiverPhone` <", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneLessThanOrEqualTo(String value) {
            addCriterion("`receiverPhone` <=", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneLike(String value) {
            addCriterion("`receiverPhone` like", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneNotLike(String value) {
            addCriterion("`receiverPhone` not like", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneIn(List<String> values) {
            addCriterion("`receiverPhone` in", values, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneNotIn(List<String> values) {
            addCriterion("`receiverPhone` not in", values, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneBetween(String value1, String value2) {
            addCriterion("`receiverPhone` between", value1, value2, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneNotBetween(String value1, String value2) {
            addCriterion("`receiverPhone` not between", value1, value2, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andSenderaddressIsNull() {
            addCriterion("`senderAddress` is null");
            return (Criteria) this;
        }

        public Criteria andSenderaddressIsNotNull() {
            addCriterion("`senderAddress` is not null");
            return (Criteria) this;
        }

        public Criteria andSenderaddressEqualTo(String value) {
            addCriterion("`senderAddress` =", value, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressNotEqualTo(String value) {
            addCriterion("`senderAddress` <>", value, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressGreaterThan(String value) {
            addCriterion("`senderAddress` >", value, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressGreaterThanOrEqualTo(String value) {
            addCriterion("`senderAddress` >=", value, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressLessThan(String value) {
            addCriterion("`senderAddress` <", value, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressLessThanOrEqualTo(String value) {
            addCriterion("`senderAddress` <=", value, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressLike(String value) {
            addCriterion("`senderAddress` like", value, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressNotLike(String value) {
            addCriterion("`senderAddress` not like", value, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressIn(List<String> values) {
            addCriterion("`senderAddress` in", values, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressNotIn(List<String> values) {
            addCriterion("`senderAddress` not in", values, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressBetween(String value1, String value2) {
            addCriterion("`senderAddress` between", value1, value2, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andSenderaddressNotBetween(String value1, String value2) {
            addCriterion("`senderAddress` not between", value1, value2, "senderaddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressIsNull() {
            addCriterion("`receiverAddress` is null");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressIsNotNull() {
            addCriterion("`receiverAddress` is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressEqualTo(String value) {
            addCriterion("`receiverAddress` =", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressNotEqualTo(String value) {
            addCriterion("`receiverAddress` <>", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressGreaterThan(String value) {
            addCriterion("`receiverAddress` >", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressGreaterThanOrEqualTo(String value) {
            addCriterion("`receiverAddress` >=", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressLessThan(String value) {
            addCriterion("`receiverAddress` <", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressLessThanOrEqualTo(String value) {
            addCriterion("`receiverAddress` <=", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressLike(String value) {
            addCriterion("`receiverAddress` like", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressNotLike(String value) {
            addCriterion("`receiverAddress` not like", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressIn(List<String> values) {
            addCriterion("`receiverAddress` in", values, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressNotIn(List<String> values) {
            addCriterion("`receiverAddress` not in", values, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressBetween(String value1, String value2) {
            addCriterion("`receiverAddress` between", value1, value2, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressNotBetween(String value1, String value2) {
            addCriterion("`receiverAddress` not between", value1, value2, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNull() {
            addCriterion("`postCode` is null");
            return (Criteria) this;
        }

        public Criteria andPostcodeIsNotNull() {
            addCriterion("`postCode` is not null");
            return (Criteria) this;
        }

        public Criteria andPostcodeEqualTo(String value) {
            addCriterion("`postCode` =", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotEqualTo(String value) {
            addCriterion("`postCode` <>", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThan(String value) {
            addCriterion("`postCode` >", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("`postCode` >=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThan(String value) {
            addCriterion("`postCode` <", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLessThanOrEqualTo(String value) {
            addCriterion("`postCode` <=", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeLike(String value) {
            addCriterion("`postCode` like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotLike(String value) {
            addCriterion("`postCode` not like", value, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeIn(List<String> values) {
            addCriterion("`postCode` in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotIn(List<String> values) {
            addCriterion("`postCode` not in", values, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeBetween(String value1, String value2) {
            addCriterion("`postCode` between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andPostcodeNotBetween(String value1, String value2) {
            addCriterion("`postCode` not between", value1, value2, "postcode");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("`createTime` is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("`createTime` is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("`createTime` =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("`createTime` <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("`createTime` >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("`createTime` >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("`createTime` <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("`createTime` <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("`createTime` in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("`createTime` not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("`createTime` between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("`createTime` not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("`updateTime` is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("`updateTime` is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("`updateTime` =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("`updateTime` <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("`updateTime` >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("`updateTime` >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("`updateTime` <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("`updateTime` <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("`updateTime` in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("`updateTime` not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("`updateTime` between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("`updateTime` not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andCourieridIsNull() {
            addCriterion("`courierId` is null");
            return (Criteria) this;
        }

        public Criteria andCourieridIsNotNull() {
            addCriterion("`courierId` is not null");
            return (Criteria) this;
        }

        public Criteria andCourieridEqualTo(Integer value) {
            addCriterion("`courierId` =", value, "courierid");
            return (Criteria) this;
        }

        public Criteria andCourieridNotEqualTo(Integer value) {
            addCriterion("`courierId` <>", value, "courierid");
            return (Criteria) this;
        }

        public Criteria andCourieridGreaterThan(Integer value) {
            addCriterion("`courierId` >", value, "courierid");
            return (Criteria) this;
        }

        public Criteria andCourieridGreaterThanOrEqualTo(Integer value) {
            addCriterion("`courierId` >=", value, "courierid");
            return (Criteria) this;
        }

        public Criteria andCourieridLessThan(Integer value) {
            addCriterion("`courierId` <", value, "courierid");
            return (Criteria) this;
        }

        public Criteria andCourieridLessThanOrEqualTo(Integer value) {
            addCriterion("`courierId` <=", value, "courierid");
            return (Criteria) this;
        }

        public Criteria andCourieridIn(List<Integer> values) {
            addCriterion("`courierId` in", values, "courierid");
            return (Criteria) this;
        }

        public Criteria andCourieridNotIn(List<Integer> values) {
            addCriterion("`courierId` not in", values, "courierid");
            return (Criteria) this;
        }

        public Criteria andCourieridBetween(Integer value1, Integer value2) {
            addCriterion("`courierId` between", value1, value2, "courierid");
            return (Criteria) this;
        }

        public Criteria andCourieridNotBetween(Integer value1, Integer value2) {
            addCriterion("`courierId` not between", value1, value2, "courierid");
            return (Criteria) this;
        }

        public Criteria andCarnumberIsNull() {
            addCriterion("`carNumber` is null");
            return (Criteria) this;
        }

        public Criteria andCarnumberIsNotNull() {
            addCriterion("`carNumber` is not null");
            return (Criteria) this;
        }

        public Criteria andCarnumberEqualTo(Integer value) {
            addCriterion("`carNumber` =", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberNotEqualTo(Integer value) {
            addCriterion("`carNumber` <>", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberGreaterThan(Integer value) {
            addCriterion("`carNumber` >", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("`carNumber` >=", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberLessThan(Integer value) {
            addCriterion("`carNumber` <", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberLessThanOrEqualTo(Integer value) {
            addCriterion("`carNumber` <=", value, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberIn(List<Integer> values) {
            addCriterion("`carNumber` in", values, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberNotIn(List<Integer> values) {
            addCriterion("`carNumber` not in", values, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberBetween(Integer value1, Integer value2) {
            addCriterion("`carNumber` between", value1, value2, "carnumber");
            return (Criteria) this;
        }

        public Criteria andCarnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("`carNumber` not between", value1, value2, "carnumber");
            return (Criteria) this;
        }

        public Criteria andShowIsNull() {
            addCriterion("`show` is null");
            return (Criteria) this;
        }

        public Criteria andShowIsNotNull() {
            addCriterion("`show` is not null");
            return (Criteria) this;
        }

        public Criteria andShowEqualTo(Integer value) {
            addCriterion("`show` =", value, "show");
            return (Criteria) this;
        }

        public Criteria andShowNotEqualTo(Integer value) {
            addCriterion("`show` <>", value, "show");
            return (Criteria) this;
        }

        public Criteria andShowGreaterThan(Integer value) {
            addCriterion("`show` >", value, "show");
            return (Criteria) this;
        }

        public Criteria andShowGreaterThanOrEqualTo(Integer value) {
            addCriterion("`show` >=", value, "show");
            return (Criteria) this;
        }

        public Criteria andShowLessThan(Integer value) {
            addCriterion("`show` <", value, "show");
            return (Criteria) this;
        }

        public Criteria andShowLessThanOrEqualTo(Integer value) {
            addCriterion("`show` <=", value, "show");
            return (Criteria) this;
        }

        public Criteria andShowIn(List<Integer> values) {
            addCriterion("`show` in", values, "show");
            return (Criteria) this;
        }

        public Criteria andShowNotIn(List<Integer> values) {
            addCriterion("`show` not in", values, "show");
            return (Criteria) this;
        }

        public Criteria andShowBetween(Integer value1, Integer value2) {
            addCriterion("`show` between", value1, value2, "show");
            return (Criteria) this;
        }

        public Criteria andShowNotBetween(Integer value1, Integer value2) {
            addCriterion("`show` not between", value1, value2, "show");
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
    }
}