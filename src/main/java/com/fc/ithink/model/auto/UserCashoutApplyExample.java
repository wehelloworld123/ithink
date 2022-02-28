package com.fc.ithink.model.auto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import cn.hutool.core.util.StrUtil;

/**
 * 提现申请管理 UserCashoutApplyExample
 * @author xy_自动生成
 * @date 2021-05-27 14:41:23
 */
public class UserCashoutApplyExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserCashoutApplyExample() {
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
        
				
        public Criteria andCashoutAccNoIsNull() {
            addCriterion("cashout_acc_no is null");
            return (Criteria) this;
        }

        public Criteria andCashoutAccNoIsNotNull() {
            addCriterion("cashout_acc_no is not null");
            return (Criteria) this;
        }

        public Criteria andCashoutAccNoEqualTo(String value) {
            addCriterion("cashout_acc_no =", value, "cashoutAccNo");
            return (Criteria) this;
        }

        public Criteria andCashoutAccNoNotEqualTo(String value) {
            addCriterion("cashout_acc_no <>", value, "cashoutAccNo");
            return (Criteria) this;
        }

        public Criteria andCashoutAccNoGreaterThan(String value) {
            addCriterion("cashout_acc_no >", value, "cashoutAccNo");
            return (Criteria) this;
        }

        public Criteria andCashoutAccNoGreaterThanOrEqualTo(String value) {
            addCriterion("cashout_acc_no >=", value, "cashoutAccNo");
            return (Criteria) this;
        }

        public Criteria andCashoutAccNoLessThan(String value) {
            addCriterion("cashout_acc_no <", value, "cashoutAccNo");
            return (Criteria) this;
        }

        public Criteria andCashoutAccNoLessThanOrEqualTo(String value) {
            addCriterion("cashout_acc_no <=", value, "cashoutAccNo");
            return (Criteria) this;
        }

        public Criteria andCashoutAccNoLike(String value) {
            addCriterion("cashout_acc_no like", value, "cashoutAccNo");
            return (Criteria) this;
        }

        public Criteria andCashoutAccNoNotLike(String value) {
            addCriterion("cashout_acc_no not like", value, "cashoutAccNo");
            return (Criteria) this;
        }

        public Criteria andCashoutAccNoIn(List<String> values) {
            addCriterion("cashout_acc_no in", values, "cashoutAccNo");
            return (Criteria) this;
        }

        public Criteria andCashoutAccNoNotIn(List<String> values) {
            addCriterion("cashout_acc_no not in", values, "cashoutAccNo");
            return (Criteria) this;
        }

        public Criteria andCashoutAccNoBetween(String value1, String value2) {
            addCriterion("cashout_acc_no between", value1, value2, "cashoutAccNo");
            return (Criteria) this;
        }

        public Criteria andCashoutAccNoNotBetween(String value1, String value2) {
            addCriterion("cashout_acc_no not between", value1, value2, "cashoutAccNo");
            return (Criteria) this;
        }
        
				
        public Criteria andAmtIsNull() {
            addCriterion("amt is null");
            return (Criteria) this;
        }

        public Criteria andAmtIsNotNull() {
            addCriterion("amt is not null");
            return (Criteria) this;
        }

        public Criteria andAmtEqualTo(BigDecimal value) {
            addCriterion("amt =", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtNotEqualTo(BigDecimal value) {
            addCriterion("amt <>", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtGreaterThan(BigDecimal value) {
            addCriterion("amt >", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amt >=", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtLessThan(BigDecimal value) {
            addCriterion("amt <", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amt <=", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtLike(BigDecimal value) {
            addCriterion("amt like", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtNotLike(BigDecimal value) {
            addCriterion("amt not like", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtIn(List<BigDecimal> values) {
            addCriterion("amt in", values, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtNotIn(List<BigDecimal> values) {
            addCriterion("amt not in", values, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amt between", value1, value2, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amt not between", value1, value2, "amt");
            return (Criteria) this;
        }
        
				
        public Criteria andActAmtIsNull() {
            addCriterion("act_amt is null");
            return (Criteria) this;
        }

        public Criteria andActAmtIsNotNull() {
            addCriterion("act_amt is not null");
            return (Criteria) this;
        }

        public Criteria andActAmtEqualTo(BigDecimal value) {
            addCriterion("act_amt =", value, "actAmt");
            return (Criteria) this;
        }

        public Criteria andActAmtNotEqualTo(BigDecimal value) {
            addCriterion("act_amt <>", value, "actAmt");
            return (Criteria) this;
        }

        public Criteria andActAmtGreaterThan(BigDecimal value) {
            addCriterion("act_amt >", value, "actAmt");
            return (Criteria) this;
        }

        public Criteria andActAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("act_amt >=", value, "actAmt");
            return (Criteria) this;
        }

        public Criteria andActAmtLessThan(BigDecimal value) {
            addCriterion("act_amt <", value, "actAmt");
            return (Criteria) this;
        }

        public Criteria andActAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("act_amt <=", value, "actAmt");
            return (Criteria) this;
        }

        public Criteria andActAmtLike(BigDecimal value) {
            addCriterion("act_amt like", value, "actAmt");
            return (Criteria) this;
        }

        public Criteria andActAmtNotLike(BigDecimal value) {
            addCriterion("act_amt not like", value, "actAmt");
            return (Criteria) this;
        }

        public Criteria andActAmtIn(List<BigDecimal> values) {
            addCriterion("act_amt in", values, "actAmt");
            return (Criteria) this;
        }

        public Criteria andActAmtNotIn(List<BigDecimal> values) {
            addCriterion("act_amt not in", values, "actAmt");
            return (Criteria) this;
        }

        public Criteria andActAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("act_amt between", value1, value2, "actAmt");
            return (Criteria) this;
        }

        public Criteria andActAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("act_amt not between", value1, value2, "actAmt");
            return (Criteria) this;
        }
        
				
        public Criteria andPoundageIsNull() {
            addCriterion("poundage is null");
            return (Criteria) this;
        }

        public Criteria andPoundageIsNotNull() {
            addCriterion("poundage is not null");
            return (Criteria) this;
        }

        public Criteria andPoundageEqualTo(BigDecimal value) {
            addCriterion("poundage =", value, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageNotEqualTo(BigDecimal value) {
            addCriterion("poundage <>", value, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageGreaterThan(BigDecimal value) {
            addCriterion("poundage >", value, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("poundage >=", value, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageLessThan(BigDecimal value) {
            addCriterion("poundage <", value, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("poundage <=", value, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageLike(BigDecimal value) {
            addCriterion("poundage like", value, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageNotLike(BigDecimal value) {
            addCriterion("poundage not like", value, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageIn(List<BigDecimal> values) {
            addCriterion("poundage in", values, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageNotIn(List<BigDecimal> values) {
            addCriterion("poundage not in", values, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("poundage between", value1, value2, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("poundage not between", value1, value2, "poundage");
            return (Criteria) this;
        }
        
				
        public Criteria andFinishIsNull() {
            addCriterion("finish is null");
            return (Criteria) this;
        }

        public Criteria andFinishIsNotNull() {
            addCriterion("finish is not null");
            return (Criteria) this;
        }

        public Criteria andFinishEqualTo(String value) {
            addCriterion("finish =", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishNotEqualTo(String value) {
            addCriterion("finish <>", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishGreaterThan(String value) {
            addCriterion("finish >", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishGreaterThanOrEqualTo(String value) {
            addCriterion("finish >=", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishLessThan(String value) {
            addCriterion("finish <", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishLessThanOrEqualTo(String value) {
            addCriterion("finish <=", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishLike(String value) {
            addCriterion("finish like", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishNotLike(String value) {
            addCriterion("finish not like", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishIn(List<String> values) {
            addCriterion("finish in", values, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishNotIn(List<String> values) {
            addCriterion("finish not in", values, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishBetween(String value1, String value2) {
            addCriterion("finish between", value1, value2, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishNotBetween(String value1, String value2) {
            addCriterion("finish not between", value1, value2, "finish");
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
        
				
        public Criteria andBankFlowNoIsNull() {
            addCriterion("bank_flow_no is null");
            return (Criteria) this;
        }

        public Criteria andBankFlowNoIsNotNull() {
            addCriterion("bank_flow_no is not null");
            return (Criteria) this;
        }

        public Criteria andBankFlowNoEqualTo(String value) {
            addCriterion("bank_flow_no =", value, "bankFlowNo");
            return (Criteria) this;
        }

        public Criteria andBankFlowNoNotEqualTo(String value) {
            addCriterion("bank_flow_no <>", value, "bankFlowNo");
            return (Criteria) this;
        }

        public Criteria andBankFlowNoGreaterThan(String value) {
            addCriterion("bank_flow_no >", value, "bankFlowNo");
            return (Criteria) this;
        }

        public Criteria andBankFlowNoGreaterThanOrEqualTo(String value) {
            addCriterion("bank_flow_no >=", value, "bankFlowNo");
            return (Criteria) this;
        }

        public Criteria andBankFlowNoLessThan(String value) {
            addCriterion("bank_flow_no <", value, "bankFlowNo");
            return (Criteria) this;
        }

        public Criteria andBankFlowNoLessThanOrEqualTo(String value) {
            addCriterion("bank_flow_no <=", value, "bankFlowNo");
            return (Criteria) this;
        }

        public Criteria andBankFlowNoLike(String value) {
            addCriterion("bank_flow_no like", value, "bankFlowNo");
            return (Criteria) this;
        }

        public Criteria andBankFlowNoNotLike(String value) {
            addCriterion("bank_flow_no not like", value, "bankFlowNo");
            return (Criteria) this;
        }

        public Criteria andBankFlowNoIn(List<String> values) {
            addCriterion("bank_flow_no in", values, "bankFlowNo");
            return (Criteria) this;
        }

        public Criteria andBankFlowNoNotIn(List<String> values) {
            addCriterion("bank_flow_no not in", values, "bankFlowNo");
            return (Criteria) this;
        }

        public Criteria andBankFlowNoBetween(String value1, String value2) {
            addCriterion("bank_flow_no between", value1, value2, "bankFlowNo");
            return (Criteria) this;
        }

        public Criteria andBankFlowNoNotBetween(String value1, String value2) {
            addCriterion("bank_flow_no not between", value1, value2, "bankFlowNo");
            return (Criteria) this;
        }
        
			
		 public Criteria andLikeQuery(UserCashoutApply record) {
		 	List<String> list= new ArrayList<String>();
		 	List<String> list2= new ArrayList<String>();
        	StringBuffer buffer=new StringBuffer();
			if(record.getId()!=null&&StrUtil.isNotEmpty(record.getId().toString())) {
    			 list.add("ifnull(id,'')");
    		}
			if(record.getCashoutAccNo()!=null&&StrUtil.isNotEmpty(record.getCashoutAccNo().toString())) {
    			 list.add("ifnull(cashout_acc_no,'')");
    		}
			if(record.getAmt()!=null&&StrUtil.isNotEmpty(record.getAmt().toString())) {
    			 list.add("ifnull(amt,'')");
    		}
			if(record.getActAmt()!=null&&StrUtil.isNotEmpty(record.getActAmt().toString())) {
    			 list.add("ifnull(act_amt,'')");
    		}
			if(record.getPoundage()!=null&&StrUtil.isNotEmpty(record.getPoundage().toString())) {
    			 list.add("ifnull(poundage,'')");
    		}
			if(record.getFinish()!=null&&StrUtil.isNotEmpty(record.getFinish().toString())) {
    			 list.add("ifnull(finish,'')");
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
			if(record.getBankFlowNo()!=null&&StrUtil.isNotEmpty(record.getBankFlowNo().toString())) {
    			 list.add("ifnull(bank_flow_no,'')");
    		}
			if(record.getId()!=null&&StrUtil.isNotEmpty(record.getId().toString())) {
    			list2.add("'%"+record.getId()+"%'");
    		}
			if(record.getCashoutAccNo()!=null&&StrUtil.isNotEmpty(record.getCashoutAccNo().toString())) {
    			list2.add("'%"+record.getCashoutAccNo()+"%'");
    		}
			if(record.getAmt()!=null&&StrUtil.isNotEmpty(record.getAmt().toString())) {
    			list2.add("'%"+record.getAmt()+"%'");
    		}
			if(record.getActAmt()!=null&&StrUtil.isNotEmpty(record.getActAmt().toString())) {
    			list2.add("'%"+record.getActAmt()+"%'");
    		}
			if(record.getPoundage()!=null&&StrUtil.isNotEmpty(record.getPoundage().toString())) {
    			list2.add("'%"+record.getPoundage()+"%'");
    		}
			if(record.getFinish()!=null&&StrUtil.isNotEmpty(record.getFinish().toString())) {
    			list2.add("'%"+record.getFinish()+"%'");
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
			if(record.getBankFlowNo()!=null&&StrUtil.isNotEmpty(record.getBankFlowNo().toString())) {
    			list2.add("'%"+record.getBankFlowNo()+"%'");
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
    		list.add("ifnull(cashout_acc_no,'')");
    		list.add("ifnull(amt,'')");
    		list.add("ifnull(act_amt,'')");
    		list.add("ifnull(poundage,'')");
    		list.add("ifnull(finish,'')");
    		list.add("ifnull(create_by,'')");
    		list.add("ifnull(create_dat,'')");
    		list.add("ifnull(l_update_dat,'')");
    		list.add("ifnull(is_del,'')");
    		list.add("ifnull(bank_flow_no,'')");
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