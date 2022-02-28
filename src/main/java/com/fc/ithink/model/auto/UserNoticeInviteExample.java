package com.fc.ithink.model.auto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import cn.hutool.core.util.StrUtil;

/**
 * 用户邀请通知 UserNoticeInviteExample
 * @author xy_自动生成
 * @date 2021-06-04 09:49:12
 */
public class UserNoticeInviteExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserNoticeInviteExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(Long value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(Long value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }
        
				
        public Criteria andInviteeIdIsNull() {
            addCriterion("invitee_id is null");
            return (Criteria) this;
        }

        public Criteria andInviteeIdIsNotNull() {
            addCriterion("invitee_id is not null");
            return (Criteria) this;
        }

        public Criteria andInviteeIdEqualTo(String value) {
            addCriterion("invitee_id =", value, "inviteeId");
            return (Criteria) this;
        }

        public Criteria andInviteeIdNotEqualTo(String value) {
            addCriterion("invitee_id <>", value, "inviteeId");
            return (Criteria) this;
        }

        public Criteria andInviteeIdGreaterThan(String value) {
            addCriterion("invitee_id >", value, "inviteeId");
            return (Criteria) this;
        }

        public Criteria andInviteeIdGreaterThanOrEqualTo(String value) {
            addCriterion("invitee_id >=", value, "inviteeId");
            return (Criteria) this;
        }

        public Criteria andInviteeIdLessThan(String value) {
            addCriterion("invitee_id <", value, "inviteeId");
            return (Criteria) this;
        }

        public Criteria andInviteeIdLessThanOrEqualTo(String value) {
            addCriterion("invitee_id <=", value, "inviteeId");
            return (Criteria) this;
        }

        public Criteria andInviteeIdLike(String value) {
            addCriterion("invitee_id like", value, "inviteeId");
            return (Criteria) this;
        }

        public Criteria andInviteeIdNotLike(String value) {
            addCriterion("invitee_id not like", value, "inviteeId");
            return (Criteria) this;
        }

        public Criteria andInviteeIdIn(List<String> values) {
            addCriterion("invitee_id in", values, "inviteeId");
            return (Criteria) this;
        }

        public Criteria andInviteeIdNotIn(List<String> values) {
            addCriterion("invitee_id not in", values, "inviteeId");
            return (Criteria) this;
        }

        public Criteria andInviteeIdBetween(String value1, String value2) {
            addCriterion("invitee_id between", value1, value2, "inviteeId");
            return (Criteria) this;
        }

        public Criteria andInviteeIdNotBetween(String value1, String value2) {
            addCriterion("invitee_id not between", value1, value2, "inviteeId");
            return (Criteria) this;
        }
        
				
        public Criteria andInviteeNmIsNull() {
            addCriterion("invitee_nm is null");
            return (Criteria) this;
        }

        public Criteria andInviteeNmIsNotNull() {
            addCriterion("invitee_nm is not null");
            return (Criteria) this;
        }

        public Criteria andInviteeNmEqualTo(String value) {
            addCriterion("invitee_nm =", value, "inviteeNm");
            return (Criteria) this;
        }

        public Criteria andInviteeNmNotEqualTo(String value) {
            addCriterion("invitee_nm <>", value, "inviteeNm");
            return (Criteria) this;
        }

        public Criteria andInviteeNmGreaterThan(String value) {
            addCriterion("invitee_nm >", value, "inviteeNm");
            return (Criteria) this;
        }

        public Criteria andInviteeNmGreaterThanOrEqualTo(String value) {
            addCriterion("invitee_nm >=", value, "inviteeNm");
            return (Criteria) this;
        }

        public Criteria andInviteeNmLessThan(String value) {
            addCriterion("invitee_nm <", value, "inviteeNm");
            return (Criteria) this;
        }

        public Criteria andInviteeNmLessThanOrEqualTo(String value) {
            addCriterion("invitee_nm <=", value, "inviteeNm");
            return (Criteria) this;
        }

        public Criteria andInviteeNmLike(String value) {
            addCriterion("invitee_nm like", value, "inviteeNm");
            return (Criteria) this;
        }

        public Criteria andInviteeNmNotLike(String value) {
            addCriterion("invitee_nm not like", value, "inviteeNm");
            return (Criteria) this;
        }

        public Criteria andInviteeNmIn(List<String> values) {
            addCriterion("invitee_nm in", values, "inviteeNm");
            return (Criteria) this;
        }

        public Criteria andInviteeNmNotIn(List<String> values) {
            addCriterion("invitee_nm not in", values, "inviteeNm");
            return (Criteria) this;
        }

        public Criteria andInviteeNmBetween(String value1, String value2) {
            addCriterion("invitee_nm between", value1, value2, "inviteeNm");
            return (Criteria) this;
        }

        public Criteria andInviteeNmNotBetween(String value1, String value2) {
            addCriterion("invitee_nm not between", value1, value2, "inviteeNm");
            return (Criteria) this;
        }
        
				
        public Criteria andInvitorIdIsNull() {
            addCriterion("invitor_id is null");
            return (Criteria) this;
        }

        public Criteria andInvitorIdIsNotNull() {
            addCriterion("invitor_id is not null");
            return (Criteria) this;
        }

        public Criteria andInvitorIdEqualTo(String value) {
            addCriterion("invitor_id =", value, "invitorId");
            return (Criteria) this;
        }

        public Criteria andInvitorIdNotEqualTo(String value) {
            addCriterion("invitor_id <>", value, "invitorId");
            return (Criteria) this;
        }

        public Criteria andInvitorIdGreaterThan(String value) {
            addCriterion("invitor_id >", value, "invitorId");
            return (Criteria) this;
        }

        public Criteria andInvitorIdGreaterThanOrEqualTo(String value) {
            addCriterion("invitor_id >=", value, "invitorId");
            return (Criteria) this;
        }

        public Criteria andInvitorIdLessThan(String value) {
            addCriterion("invitor_id <", value, "invitorId");
            return (Criteria) this;
        }

        public Criteria andInvitorIdLessThanOrEqualTo(String value) {
            addCriterion("invitor_id <=", value, "invitorId");
            return (Criteria) this;
        }

        public Criteria andInvitorIdLike(String value) {
            addCriterion("invitor_id like", value, "invitorId");
            return (Criteria) this;
        }

        public Criteria andInvitorIdNotLike(String value) {
            addCriterion("invitor_id not like", value, "invitorId");
            return (Criteria) this;
        }

        public Criteria andInvitorIdIn(List<String> values) {
            addCriterion("invitor_id in", values, "invitorId");
            return (Criteria) this;
        }

        public Criteria andInvitorIdNotIn(List<String> values) {
            addCriterion("invitor_id not in", values, "invitorId");
            return (Criteria) this;
        }

        public Criteria andInvitorIdBetween(String value1, String value2) {
            addCriterion("invitor_id between", value1, value2, "invitorId");
            return (Criteria) this;
        }

        public Criteria andInvitorIdNotBetween(String value1, String value2) {
            addCriterion("invitor_id not between", value1, value2, "invitorId");
            return (Criteria) this;
        }
        
				
        public Criteria andInvitorNmIsNull() {
            addCriterion("invitor_nm is null");
            return (Criteria) this;
        }

        public Criteria andInvitorNmIsNotNull() {
            addCriterion("invitor_nm is not null");
            return (Criteria) this;
        }

        public Criteria andInvitorNmEqualTo(String value) {
            addCriterion("invitor_nm =", value, "invitorNm");
            return (Criteria) this;
        }

        public Criteria andInvitorNmNotEqualTo(String value) {
            addCriterion("invitor_nm <>", value, "invitorNm");
            return (Criteria) this;
        }

        public Criteria andInvitorNmGreaterThan(String value) {
            addCriterion("invitor_nm >", value, "invitorNm");
            return (Criteria) this;
        }

        public Criteria andInvitorNmGreaterThanOrEqualTo(String value) {
            addCriterion("invitor_nm >=", value, "invitorNm");
            return (Criteria) this;
        }

        public Criteria andInvitorNmLessThan(String value) {
            addCriterion("invitor_nm <", value, "invitorNm");
            return (Criteria) this;
        }

        public Criteria andInvitorNmLessThanOrEqualTo(String value) {
            addCriterion("invitor_nm <=", value, "invitorNm");
            return (Criteria) this;
        }

        public Criteria andInvitorNmLike(String value) {
            addCriterion("invitor_nm like", value, "invitorNm");
            return (Criteria) this;
        }

        public Criteria andInvitorNmNotLike(String value) {
            addCriterion("invitor_nm not like", value, "invitorNm");
            return (Criteria) this;
        }

        public Criteria andInvitorNmIn(List<String> values) {
            addCriterion("invitor_nm in", values, "invitorNm");
            return (Criteria) this;
        }

        public Criteria andInvitorNmNotIn(List<String> values) {
            addCriterion("invitor_nm not in", values, "invitorNm");
            return (Criteria) this;
        }

        public Criteria andInvitorNmBetween(String value1, String value2) {
            addCriterion("invitor_nm between", value1, value2, "invitorNm");
            return (Criteria) this;
        }

        public Criteria andInvitorNmNotBetween(String value1, String value2) {
            addCriterion("invitor_nm not between", value1, value2, "invitorNm");
            return (Criteria) this;
        }
        
				
        public Criteria andProNoIsNull() {
            addCriterion("pro_no is null");
            return (Criteria) this;
        }

        public Criteria andProNoIsNotNull() {
            addCriterion("pro_no is not null");
            return (Criteria) this;
        }

        public Criteria andProNoEqualTo(String value) {
            addCriterion("pro_no =", value, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoNotEqualTo(String value) {
            addCriterion("pro_no <>", value, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoGreaterThan(String value) {
            addCriterion("pro_no >", value, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoGreaterThanOrEqualTo(String value) {
            addCriterion("pro_no >=", value, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoLessThan(String value) {
            addCriterion("pro_no <", value, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoLessThanOrEqualTo(String value) {
            addCriterion("pro_no <=", value, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoLike(String value) {
            addCriterion("pro_no like", value, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoNotLike(String value) {
            addCriterion("pro_no not like", value, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoIn(List<String> values) {
            addCriterion("pro_no in", values, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoNotIn(List<String> values) {
            addCriterion("pro_no not in", values, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoBetween(String value1, String value2) {
            addCriterion("pro_no between", value1, value2, "proNo");
            return (Criteria) this;
        }

        public Criteria andProNoNotBetween(String value1, String value2) {
            addCriterion("pro_no not between", value1, value2, "proNo");
            return (Criteria) this;
        }
        
				
        public Criteria andProTypeIsNull() {
            addCriterion("pro_type is null");
            return (Criteria) this;
        }

        public Criteria andProTypeIsNotNull() {
            addCriterion("pro_type is not null");
            return (Criteria) this;
        }

        public Criteria andProTypeEqualTo(String value) {
            addCriterion("pro_type =", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotEqualTo(String value) {
            addCriterion("pro_type <>", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeGreaterThan(String value) {
            addCriterion("pro_type >", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pro_type >=", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeLessThan(String value) {
            addCriterion("pro_type <", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeLessThanOrEqualTo(String value) {
            addCriterion("pro_type <=", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeLike(String value) {
            addCriterion("pro_type like", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotLike(String value) {
            addCriterion("pro_type not like", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeIn(List<String> values) {
            addCriterion("pro_type in", values, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotIn(List<String> values) {
            addCriterion("pro_type not in", values, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeBetween(String value1, String value2) {
            addCriterion("pro_type between", value1, value2, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotBetween(String value1, String value2) {
            addCriterion("pro_type not between", value1, value2, "proType");
            return (Criteria) this;
        }
        
				
        public Criteria andProNmIsNull() {
            addCriterion("pro_nm is null");
            return (Criteria) this;
        }

        public Criteria andProNmIsNotNull() {
            addCriterion("pro_nm is not null");
            return (Criteria) this;
        }

        public Criteria andProNmEqualTo(String value) {
            addCriterion("pro_nm =", value, "proNm");
            return (Criteria) this;
        }

        public Criteria andProNmNotEqualTo(String value) {
            addCriterion("pro_nm <>", value, "proNm");
            return (Criteria) this;
        }

        public Criteria andProNmGreaterThan(String value) {
            addCriterion("pro_nm >", value, "proNm");
            return (Criteria) this;
        }

        public Criteria andProNmGreaterThanOrEqualTo(String value) {
            addCriterion("pro_nm >=", value, "proNm");
            return (Criteria) this;
        }

        public Criteria andProNmLessThan(String value) {
            addCriterion("pro_nm <", value, "proNm");
            return (Criteria) this;
        }

        public Criteria andProNmLessThanOrEqualTo(String value) {
            addCriterion("pro_nm <=", value, "proNm");
            return (Criteria) this;
        }

        public Criteria andProNmLike(String value) {
            addCriterion("pro_nm like", value, "proNm");
            return (Criteria) this;
        }

        public Criteria andProNmNotLike(String value) {
            addCriterion("pro_nm not like", value, "proNm");
            return (Criteria) this;
        }

        public Criteria andProNmIn(List<String> values) {
            addCriterion("pro_nm in", values, "proNm");
            return (Criteria) this;
        }

        public Criteria andProNmNotIn(List<String> values) {
            addCriterion("pro_nm not in", values, "proNm");
            return (Criteria) this;
        }

        public Criteria andProNmBetween(String value1, String value2) {
            addCriterion("pro_nm between", value1, value2, "proNm");
            return (Criteria) this;
        }

        public Criteria andProNmNotBetween(String value1, String value2) {
            addCriterion("pro_nm not between", value1, value2, "proNm");
            return (Criteria) this;
        }
        
				
        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
        
				
        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
        
				
        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }
        
				
        public Criteria andCreateDatIsNull() {
            addCriterion("create_dat is null");
            return (Criteria) this;
        }

        public Criteria andCreateDatIsNotNull() {
            addCriterion("create_dat is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDatEqualTo(Date value) {
            addCriterion("create_dat =", value, "createDat");
            return (Criteria) this;
        }

        public Criteria andCreateDatNotEqualTo(Date value) {
            addCriterion("create_dat <>", value, "createDat");
            return (Criteria) this;
        }

        public Criteria andCreateDatGreaterThan(Date value) {
            addCriterion("create_dat >", value, "createDat");
            return (Criteria) this;
        }

        public Criteria andCreateDatGreaterThanOrEqualTo(Date value) {
            addCriterion("create_dat >=", value, "createDat");
            return (Criteria) this;
        }

        public Criteria andCreateDatLessThan(Date value) {
            addCriterion("create_dat <", value, "createDat");
            return (Criteria) this;
        }

        public Criteria andCreateDatLessThanOrEqualTo(Date value) {
            addCriterion("create_dat <=", value, "createDat");
            return (Criteria) this;
        }

        public Criteria andCreateDatLike(Date value) {
            addCriterion("create_dat like", value, "createDat");
            return (Criteria) this;
        }

        public Criteria andCreateDatNotLike(Date value) {
            addCriterion("create_dat not like", value, "createDat");
            return (Criteria) this;
        }

        public Criteria andCreateDatIn(List<Date> values) {
            addCriterion("create_dat in", values, "createDat");
            return (Criteria) this;
        }

        public Criteria andCreateDatNotIn(List<Date> values) {
            addCriterion("create_dat not in", values, "createDat");
            return (Criteria) this;
        }

        public Criteria andCreateDatBetween(Date value1, Date value2) {
            addCriterion("create_dat between", value1, value2, "createDat");
            return (Criteria) this;
        }

        public Criteria andCreateDatNotBetween(Date value1, Date value2) {
            addCriterion("create_dat not between", value1, value2, "createDat");
            return (Criteria) this;
        }
        
				
        public Criteria andLUpdateDatIsNull() {
            addCriterion("l_update_dat is null");
            return (Criteria) this;
        }

        public Criteria andLUpdateDatIsNotNull() {
            addCriterion("l_update_dat is not null");
            return (Criteria) this;
        }

        public Criteria andLUpdateDatEqualTo(Date value) {
            addCriterion("l_update_dat =", value, "lUpdateDat");
            return (Criteria) this;
        }

        public Criteria andLUpdateDatNotEqualTo(Date value) {
            addCriterion("l_update_dat <>", value, "lUpdateDat");
            return (Criteria) this;
        }

        public Criteria andLUpdateDatGreaterThan(Date value) {
            addCriterion("l_update_dat >", value, "lUpdateDat");
            return (Criteria) this;
        }

        public Criteria andLUpdateDatGreaterThanOrEqualTo(Date value) {
            addCriterion("l_update_dat >=", value, "lUpdateDat");
            return (Criteria) this;
        }

        public Criteria andLUpdateDatLessThan(Date value) {
            addCriterion("l_update_dat <", value, "lUpdateDat");
            return (Criteria) this;
        }

        public Criteria andLUpdateDatLessThanOrEqualTo(Date value) {
            addCriterion("l_update_dat <=", value, "lUpdateDat");
            return (Criteria) this;
        }

        public Criteria andLUpdateDatLike(Date value) {
            addCriterion("l_update_dat like", value, "lUpdateDat");
            return (Criteria) this;
        }

        public Criteria andLUpdateDatNotLike(Date value) {
            addCriterion("l_update_dat not like", value, "lUpdateDat");
            return (Criteria) this;
        }

        public Criteria andLUpdateDatIn(List<Date> values) {
            addCriterion("l_update_dat in", values, "lUpdateDat");
            return (Criteria) this;
        }

        public Criteria andLUpdateDatNotIn(List<Date> values) {
            addCriterion("l_update_dat not in", values, "lUpdateDat");
            return (Criteria) this;
        }

        public Criteria andLUpdateDatBetween(Date value1, Date value2) {
            addCriterion("l_update_dat between", value1, value2, "lUpdateDat");
            return (Criteria) this;
        }

        public Criteria andLUpdateDatNotBetween(Date value1, Date value2) {
            addCriterion("l_update_dat not between", value1, value2, "lUpdateDat");
            return (Criteria) this;
        }
        
				
        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(Integer value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(Integer value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(Integer value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(Integer value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(Integer value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLike(Integer value) {
            addCriterion("is_del like", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotLike(Integer value) {
            addCriterion("is_del not like", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<Integer> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<Integer> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(Integer value1, Integer value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(Integer value1, Integer value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
            return (Criteria) this;
        }
        
			
		 public Criteria andLikeQuery(UserNoticeInvite record) {
		 	List<String> list= new ArrayList<String>();
		 	List<String> list2= new ArrayList<String>();
        	StringBuffer buffer=new StringBuffer();
			if(record.getId()!=null&&StrUtil.isNotEmpty(record.getId().toString())) {
    			 list.add("ifnull(id,'')");
    		}
			if(record.getInviteeId()!=null&&StrUtil.isNotEmpty(record.getInviteeId().toString())) {
    			 list.add("ifnull(invitee_id,'')");
    		}
			if(record.getInviteeNm()!=null&&StrUtil.isNotEmpty(record.getInviteeNm().toString())) {
    			 list.add("ifnull(invitee_nm,'')");
    		}
			if(record.getInvitorId()!=null&&StrUtil.isNotEmpty(record.getInvitorId().toString())) {
    			 list.add("ifnull(invitor_id,'')");
    		}
			if(record.getInvitorNm()!=null&&StrUtil.isNotEmpty(record.getInvitorNm().toString())) {
    			 list.add("ifnull(invitor_nm,'')");
    		}
			if(record.getProNo()!=null&&StrUtil.isNotEmpty(record.getProNo().toString())) {
    			 list.add("ifnull(pro_no,'')");
    		}
			if(record.getProType()!=null&&StrUtil.isNotEmpty(record.getProType().toString())) {
    			 list.add("ifnull(pro_type,'')");
    		}
			if(record.getProNm()!=null&&StrUtil.isNotEmpty(record.getProNm().toString())) {
    			 list.add("ifnull(pro_nm,'')");
    		}
			if(record.getRemark()!=null&&StrUtil.isNotEmpty(record.getRemark().toString())) {
    			 list.add("ifnull(remark,'')");
    		}
			if(record.getStatus()!=null&&StrUtil.isNotEmpty(record.getStatus().toString())) {
    			 list.add("ifnull(status,'')");
    		}
			if(record.getCreateBy()!=null&&StrUtil.isNotEmpty(record.getCreateBy().toString())) {
    			 list.add("ifnull(create_by,'')");
    		}
			if(record.getCreateDat()!=null&&StrUtil.isNotEmpty(record.getCreateDat().toString())) {
    			 list.add("ifnull(create_dat,'')");
    		}
			if(record.getLUpdateDat()!=null&&StrUtil.isNotEmpty(record.getLUpdateDat().toString())) {
    			 list.add("ifnull(l_update_dat,'')");
    		}
			if(record.getIsDel()!=null&&StrUtil.isNotEmpty(record.getIsDel().toString())) {
    			 list.add("ifnull(is_del,'')");
    		}
			if(record.getId()!=null&&StrUtil.isNotEmpty(record.getId().toString())) {
    			list2.add("'%"+record.getId()+"%'");
    		}
			if(record.getInviteeId()!=null&&StrUtil.isNotEmpty(record.getInviteeId().toString())) {
    			list2.add("'%"+record.getInviteeId()+"%'");
    		}
			if(record.getInviteeNm()!=null&&StrUtil.isNotEmpty(record.getInviteeNm().toString())) {
    			list2.add("'%"+record.getInviteeNm()+"%'");
    		}
			if(record.getInvitorId()!=null&&StrUtil.isNotEmpty(record.getInvitorId().toString())) {
    			list2.add("'%"+record.getInvitorId()+"%'");
    		}
			if(record.getInvitorNm()!=null&&StrUtil.isNotEmpty(record.getInvitorNm().toString())) {
    			list2.add("'%"+record.getInvitorNm()+"%'");
    		}
			if(record.getProNo()!=null&&StrUtil.isNotEmpty(record.getProNo().toString())) {
    			list2.add("'%"+record.getProNo()+"%'");
    		}
			if(record.getProType()!=null&&StrUtil.isNotEmpty(record.getProType().toString())) {
    			list2.add("'%"+record.getProType()+"%'");
    		}
			if(record.getProNm()!=null&&StrUtil.isNotEmpty(record.getProNm().toString())) {
    			list2.add("'%"+record.getProNm()+"%'");
    		}
			if(record.getRemark()!=null&&StrUtil.isNotEmpty(record.getRemark().toString())) {
    			list2.add("'%"+record.getRemark()+"%'");
    		}
			if(record.getStatus()!=null&&StrUtil.isNotEmpty(record.getStatus().toString())) {
    			list2.add("'%"+record.getStatus()+"%'");
    		}
			if(record.getCreateBy()!=null&&StrUtil.isNotEmpty(record.getCreateBy().toString())) {
    			list2.add("'%"+record.getCreateBy()+"%'");
    		}
			if(record.getCreateDat()!=null&&StrUtil.isNotEmpty(record.getCreateDat().toString())) {
    			list2.add("'%"+record.getCreateDat()+"%'");
    		}
			if(record.getLUpdateDat()!=null&&StrUtil.isNotEmpty(record.getLUpdateDat().toString())) {
    			list2.add("'%"+record.getLUpdateDat()+"%'");
    		}
			if(record.getIsDel()!=null&&StrUtil.isNotEmpty(record.getIsDel().toString())) {
    			list2.add("'%"+record.getIsDel()+"%'");
    		}
        	buffer.append(" CONCAT(");
	        buffer.append(StrUtil.join(",",list));
        	buffer.append(")");
        	buffer.append(" like CONCAT(");
        	buffer.append(StrUtil.join(",",list2));
        	buffer.append(")");
        	if(!" CONCAT() like CONCAT()".equals(buffer.toString())) {
        		addCriterion(buffer.toString());
        	}
        	return (Criteria) this;
        }
        
        public Criteria andLikeQuery2(String searchText) {
		 	List<String> list= new ArrayList<String>();
        	StringBuffer buffer=new StringBuffer();
    		list.add("ifnull(id,'')");
    		list.add("ifnull(invitee_id,'')");
    		list.add("ifnull(invitee_nm,'')");
    		list.add("ifnull(invitor_id,'')");
    		list.add("ifnull(invitor_nm,'')");
    		list.add("ifnull(pro_no,'')");
    		list.add("ifnull(pro_type,'')");
    		list.add("ifnull(pro_nm,'')");
    		list.add("ifnull(remark,'')");
    		list.add("ifnull(status,'')");
    		list.add("ifnull(create_by,'')");
    		list.add("ifnull(create_dat,'')");
    		list.add("ifnull(l_update_dat,'')");
    		list.add("ifnull(is_del,'')");
        	buffer.append(" CONCAT(");
	        buffer.append(StrUtil.join(",",list));
        	buffer.append(")");
        	buffer.append("like '%");
        	buffer.append(searchText);
        	buffer.append("%'");
        	addCriterion(buffer.toString());
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