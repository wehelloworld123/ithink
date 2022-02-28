package com.fc.ithink.model.auto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import cn.hutool.core.util.StrUtil;

/**
 * 用户提现账号 UserCashoutAccExample
 * @author xy_自动生成
 * @date 2021-05-27 14:46:25
 */
public class UserCashoutAccExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserCashoutAccExample() {
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
        
				
        public Criteria andNoIsNull() {
            addCriterion("no is null");
            return (Criteria) this;
        }

        public Criteria andNoIsNotNull() {
            addCriterion("no is not null");
            return (Criteria) this;
        }

        public Criteria andNoEqualTo(String value) {
            addCriterion("no =", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotEqualTo(String value) {
            addCriterion("no <>", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThan(String value) {
            addCriterion("no >", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThanOrEqualTo(String value) {
            addCriterion("no >=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThan(String value) {
            addCriterion("no <", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThanOrEqualTo(String value) {
            addCriterion("no <=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLike(String value) {
            addCriterion("no like", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotLike(String value) {
            addCriterion("no not like", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoIn(List<String> values) {
            addCriterion("no in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotIn(List<String> values) {
            addCriterion("no not in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoBetween(String value1, String value2) {
            addCriterion("no between", value1, value2, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotBetween(String value1, String value2) {
            addCriterion("no not between", value1, value2, "no");
            return (Criteria) this;
        }
        
				
        public Criteria andPayeeWayIsNull() {
            addCriterion("payee_way is null");
            return (Criteria) this;
        }

        public Criteria andPayeeWayIsNotNull() {
            addCriterion("payee_way is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeWayEqualTo(String value) {
            addCriterion("payee_way =", value, "payeeWay");
            return (Criteria) this;
        }

        public Criteria andPayeeWayNotEqualTo(String value) {
            addCriterion("payee_way <>", value, "payeeWay");
            return (Criteria) this;
        }

        public Criteria andPayeeWayGreaterThan(String value) {
            addCriterion("payee_way >", value, "payeeWay");
            return (Criteria) this;
        }

        public Criteria andPayeeWayGreaterThanOrEqualTo(String value) {
            addCriterion("payee_way >=", value, "payeeWay");
            return (Criteria) this;
        }

        public Criteria andPayeeWayLessThan(String value) {
            addCriterion("payee_way <", value, "payeeWay");
            return (Criteria) this;
        }

        public Criteria andPayeeWayLessThanOrEqualTo(String value) {
            addCriterion("payee_way <=", value, "payeeWay");
            return (Criteria) this;
        }

        public Criteria andPayeeWayLike(String value) {
            addCriterion("payee_way like", value, "payeeWay");
            return (Criteria) this;
        }

        public Criteria andPayeeWayNotLike(String value) {
            addCriterion("payee_way not like", value, "payeeWay");
            return (Criteria) this;
        }

        public Criteria andPayeeWayIn(List<String> values) {
            addCriterion("payee_way in", values, "payeeWay");
            return (Criteria) this;
        }

        public Criteria andPayeeWayNotIn(List<String> values) {
            addCriterion("payee_way not in", values, "payeeWay");
            return (Criteria) this;
        }

        public Criteria andPayeeWayBetween(String value1, String value2) {
            addCriterion("payee_way between", value1, value2, "payeeWay");
            return (Criteria) this;
        }

        public Criteria andPayeeWayNotBetween(String value1, String value2) {
            addCriterion("payee_way not between", value1, value2, "payeeWay");
            return (Criteria) this;
        }
        
				
        public Criteria andBankNmIsNull() {
            addCriterion("bank_nm is null");
            return (Criteria) this;
        }

        public Criteria andBankNmIsNotNull() {
            addCriterion("bank_nm is not null");
            return (Criteria) this;
        }

        public Criteria andBankNmEqualTo(String value) {
            addCriterion("bank_nm =", value, "bankNm");
            return (Criteria) this;
        }

        public Criteria andBankNmNotEqualTo(String value) {
            addCriterion("bank_nm <>", value, "bankNm");
            return (Criteria) this;
        }

        public Criteria andBankNmGreaterThan(String value) {
            addCriterion("bank_nm >", value, "bankNm");
            return (Criteria) this;
        }

        public Criteria andBankNmGreaterThanOrEqualTo(String value) {
            addCriterion("bank_nm >=", value, "bankNm");
            return (Criteria) this;
        }

        public Criteria andBankNmLessThan(String value) {
            addCriterion("bank_nm <", value, "bankNm");
            return (Criteria) this;
        }

        public Criteria andBankNmLessThanOrEqualTo(String value) {
            addCriterion("bank_nm <=", value, "bankNm");
            return (Criteria) this;
        }

        public Criteria andBankNmLike(String value) {
            addCriterion("bank_nm like", value, "bankNm");
            return (Criteria) this;
        }

        public Criteria andBankNmNotLike(String value) {
            addCriterion("bank_nm not like", value, "bankNm");
            return (Criteria) this;
        }

        public Criteria andBankNmIn(List<String> values) {
            addCriterion("bank_nm in", values, "bankNm");
            return (Criteria) this;
        }

        public Criteria andBankNmNotIn(List<String> values) {
            addCriterion("bank_nm not in", values, "bankNm");
            return (Criteria) this;
        }

        public Criteria andBankNmBetween(String value1, String value2) {
            addCriterion("bank_nm between", value1, value2, "bankNm");
            return (Criteria) this;
        }

        public Criteria andBankNmNotBetween(String value1, String value2) {
            addCriterion("bank_nm not between", value1, value2, "bankNm");
            return (Criteria) this;
        }
        
				
        public Criteria andBankCodeIsNull() {
            addCriterion("bank_code is null");
            return (Criteria) this;
        }

        public Criteria andBankCodeIsNotNull() {
            addCriterion("bank_code is not null");
            return (Criteria) this;
        }

        public Criteria andBankCodeEqualTo(String value) {
            addCriterion("bank_code =", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotEqualTo(String value) {
            addCriterion("bank_code <>", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeGreaterThan(String value) {
            addCriterion("bank_code >", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bank_code >=", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLessThan(String value) {
            addCriterion("bank_code <", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLessThanOrEqualTo(String value) {
            addCriterion("bank_code <=", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeLike(String value) {
            addCriterion("bank_code like", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotLike(String value) {
            addCriterion("bank_code not like", value, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeIn(List<String> values) {
            addCriterion("bank_code in", values, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotIn(List<String> values) {
            addCriterion("bank_code not in", values, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeBetween(String value1, String value2) {
            addCriterion("bank_code between", value1, value2, "bankCode");
            return (Criteria) this;
        }

        public Criteria andBankCodeNotBetween(String value1, String value2) {
            addCriterion("bank_code not between", value1, value2, "bankCode");
            return (Criteria) this;
        }
        
				
        public Criteria andPayeeNmIsNull() {
            addCriterion("payee_nm is null");
            return (Criteria) this;
        }

        public Criteria andPayeeNmIsNotNull() {
            addCriterion("payee_nm is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeNmEqualTo(String value) {
            addCriterion("payee_nm =", value, "payeeNm");
            return (Criteria) this;
        }

        public Criteria andPayeeNmNotEqualTo(String value) {
            addCriterion("payee_nm <>", value, "payeeNm");
            return (Criteria) this;
        }

        public Criteria andPayeeNmGreaterThan(String value) {
            addCriterion("payee_nm >", value, "payeeNm");
            return (Criteria) this;
        }

        public Criteria andPayeeNmGreaterThanOrEqualTo(String value) {
            addCriterion("payee_nm >=", value, "payeeNm");
            return (Criteria) this;
        }

        public Criteria andPayeeNmLessThan(String value) {
            addCriterion("payee_nm <", value, "payeeNm");
            return (Criteria) this;
        }

        public Criteria andPayeeNmLessThanOrEqualTo(String value) {
            addCriterion("payee_nm <=", value, "payeeNm");
            return (Criteria) this;
        }

        public Criteria andPayeeNmLike(String value) {
            addCriterion("payee_nm like", value, "payeeNm");
            return (Criteria) this;
        }

        public Criteria andPayeeNmNotLike(String value) {
            addCriterion("payee_nm not like", value, "payeeNm");
            return (Criteria) this;
        }

        public Criteria andPayeeNmIn(List<String> values) {
            addCriterion("payee_nm in", values, "payeeNm");
            return (Criteria) this;
        }

        public Criteria andPayeeNmNotIn(List<String> values) {
            addCriterion("payee_nm not in", values, "payeeNm");
            return (Criteria) this;
        }

        public Criteria andPayeeNmBetween(String value1, String value2) {
            addCriterion("payee_nm between", value1, value2, "payeeNm");
            return (Criteria) this;
        }

        public Criteria andPayeeNmNotBetween(String value1, String value2) {
            addCriterion("payee_nm not between", value1, value2, "payeeNm");
            return (Criteria) this;
        }
        
				
        public Criteria andPayeeAccIsNull() {
            addCriterion("payee_acc is null");
            return (Criteria) this;
        }

        public Criteria andPayeeAccIsNotNull() {
            addCriterion("payee_acc is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeAccEqualTo(String value) {
            addCriterion("payee_acc =", value, "payeeAcc");
            return (Criteria) this;
        }

        public Criteria andPayeeAccNotEqualTo(String value) {
            addCriterion("payee_acc <>", value, "payeeAcc");
            return (Criteria) this;
        }

        public Criteria andPayeeAccGreaterThan(String value) {
            addCriterion("payee_acc >", value, "payeeAcc");
            return (Criteria) this;
        }

        public Criteria andPayeeAccGreaterThanOrEqualTo(String value) {
            addCriterion("payee_acc >=", value, "payeeAcc");
            return (Criteria) this;
        }

        public Criteria andPayeeAccLessThan(String value) {
            addCriterion("payee_acc <", value, "payeeAcc");
            return (Criteria) this;
        }

        public Criteria andPayeeAccLessThanOrEqualTo(String value) {
            addCriterion("payee_acc <=", value, "payeeAcc");
            return (Criteria) this;
        }

        public Criteria andPayeeAccLike(String value) {
            addCriterion("payee_acc like", value, "payeeAcc");
            return (Criteria) this;
        }

        public Criteria andPayeeAccNotLike(String value) {
            addCriterion("payee_acc not like", value, "payeeAcc");
            return (Criteria) this;
        }

        public Criteria andPayeeAccIn(List<String> values) {
            addCriterion("payee_acc in", values, "payeeAcc");
            return (Criteria) this;
        }

        public Criteria andPayeeAccNotIn(List<String> values) {
            addCriterion("payee_acc not in", values, "payeeAcc");
            return (Criteria) this;
        }

        public Criteria andPayeeAccBetween(String value1, String value2) {
            addCriterion("payee_acc between", value1, value2, "payeeAcc");
            return (Criteria) this;
        }

        public Criteria andPayeeAccNotBetween(String value1, String value2) {
            addCriterion("payee_acc not between", value1, value2, "payeeAcc");
            return (Criteria) this;
        }
        
				
        public Criteria andPhoneNoIsNull() {
            addCriterion("phone_no is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNoIsNotNull() {
            addCriterion("phone_no is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNoEqualTo(String value) {
            addCriterion("phone_no =", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoNotEqualTo(String value) {
            addCriterion("phone_no <>", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoGreaterThan(String value) {
            addCriterion("phone_no >", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoGreaterThanOrEqualTo(String value) {
            addCriterion("phone_no >=", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoLessThan(String value) {
            addCriterion("phone_no <", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoLessThanOrEqualTo(String value) {
            addCriterion("phone_no <=", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoLike(String value) {
            addCriterion("phone_no like", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoNotLike(String value) {
            addCriterion("phone_no not like", value, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoIn(List<String> values) {
            addCriterion("phone_no in", values, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoNotIn(List<String> values) {
            addCriterion("phone_no not in", values, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoBetween(String value1, String value2) {
            addCriterion("phone_no between", value1, value2, "phoneNo");
            return (Criteria) this;
        }

        public Criteria andPhoneNoNotBetween(String value1, String value2) {
            addCriterion("phone_no not between", value1, value2, "phoneNo");
            return (Criteria) this;
        }
        
				
        public Criteria andDefaultWayIsNull() {
            addCriterion("default_way is null");
            return (Criteria) this;
        }

        public Criteria andDefaultWayIsNotNull() {
            addCriterion("default_way is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultWayEqualTo(String value) {
            addCriterion("default_way =", value, "defaultWay");
            return (Criteria) this;
        }

        public Criteria andDefaultWayNotEqualTo(String value) {
            addCriterion("default_way <>", value, "defaultWay");
            return (Criteria) this;
        }

        public Criteria andDefaultWayGreaterThan(String value) {
            addCriterion("default_way >", value, "defaultWay");
            return (Criteria) this;
        }

        public Criteria andDefaultWayGreaterThanOrEqualTo(String value) {
            addCriterion("default_way >=", value, "defaultWay");
            return (Criteria) this;
        }

        public Criteria andDefaultWayLessThan(String value) {
            addCriterion("default_way <", value, "defaultWay");
            return (Criteria) this;
        }

        public Criteria andDefaultWayLessThanOrEqualTo(String value) {
            addCriterion("default_way <=", value, "defaultWay");
            return (Criteria) this;
        }

        public Criteria andDefaultWayLike(String value) {
            addCriterion("default_way like", value, "defaultWay");
            return (Criteria) this;
        }

        public Criteria andDefaultWayNotLike(String value) {
            addCriterion("default_way not like", value, "defaultWay");
            return (Criteria) this;
        }

        public Criteria andDefaultWayIn(List<String> values) {
            addCriterion("default_way in", values, "defaultWay");
            return (Criteria) this;
        }

        public Criteria andDefaultWayNotIn(List<String> values) {
            addCriterion("default_way not in", values, "defaultWay");
            return (Criteria) this;
        }

        public Criteria andDefaultWayBetween(String value1, String value2) {
            addCriterion("default_way between", value1, value2, "defaultWay");
            return (Criteria) this;
        }

        public Criteria andDefaultWayNotBetween(String value1, String value2) {
            addCriterion("default_way not between", value1, value2, "defaultWay");
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
        
				
        public Criteria andBankIconIsNull() {
            addCriterion("bank_icon is null");
            return (Criteria) this;
        }

        public Criteria andBankIconIsNotNull() {
            addCriterion("bank_icon is not null");
            return (Criteria) this;
        }

        public Criteria andBankIconEqualTo(String value) {
            addCriterion("bank_icon =", value, "bankIcon");
            return (Criteria) this;
        }

        public Criteria andBankIconNotEqualTo(String value) {
            addCriterion("bank_icon <>", value, "bankIcon");
            return (Criteria) this;
        }

        public Criteria andBankIconGreaterThan(String value) {
            addCriterion("bank_icon >", value, "bankIcon");
            return (Criteria) this;
        }

        public Criteria andBankIconGreaterThanOrEqualTo(String value) {
            addCriterion("bank_icon >=", value, "bankIcon");
            return (Criteria) this;
        }

        public Criteria andBankIconLessThan(String value) {
            addCriterion("bank_icon <", value, "bankIcon");
            return (Criteria) this;
        }

        public Criteria andBankIconLessThanOrEqualTo(String value) {
            addCriterion("bank_icon <=", value, "bankIcon");
            return (Criteria) this;
        }

        public Criteria andBankIconLike(String value) {
            addCriterion("bank_icon like", value, "bankIcon");
            return (Criteria) this;
        }

        public Criteria andBankIconNotLike(String value) {
            addCriterion("bank_icon not like", value, "bankIcon");
            return (Criteria) this;
        }

        public Criteria andBankIconIn(List<String> values) {
            addCriterion("bank_icon in", values, "bankIcon");
            return (Criteria) this;
        }

        public Criteria andBankIconNotIn(List<String> values) {
            addCriterion("bank_icon not in", values, "bankIcon");
            return (Criteria) this;
        }

        public Criteria andBankIconBetween(String value1, String value2) {
            addCriterion("bank_icon between", value1, value2, "bankIcon");
            return (Criteria) this;
        }

        public Criteria andBankIconNotBetween(String value1, String value2) {
            addCriterion("bank_icon not between", value1, value2, "bankIcon");
            return (Criteria) this;
        }
        
			
		 public Criteria andLikeQuery(UserCashoutAcc record) {
		 	List<String> list= new ArrayList<String>();
		 	List<String> list2= new ArrayList<String>();
        	StringBuffer buffer=new StringBuffer();
			if(record.getNo()!=null&&StrUtil.isNotEmpty(record.getNo().toString())) {
    			 list.add("ifnull(no,'')");
    		}
			if(record.getPayeeWay()!=null&&StrUtil.isNotEmpty(record.getPayeeWay().toString())) {
    			 list.add("ifnull(payee_way,'')");
    		}
			if(record.getBankNm()!=null&&StrUtil.isNotEmpty(record.getBankNm().toString())) {
    			 list.add("ifnull(bank_nm,'')");
    		}
			if(record.getBankCode()!=null&&StrUtil.isNotEmpty(record.getBankCode().toString())) {
    			 list.add("ifnull(bank_code,'')");
    		}
			if(record.getPayeeNm()!=null&&StrUtil.isNotEmpty(record.getPayeeNm().toString())) {
    			 list.add("ifnull(payee_nm,'')");
    		}
			if(record.getPayeeAcc()!=null&&StrUtil.isNotEmpty(record.getPayeeAcc().toString())) {
    			 list.add("ifnull(payee_acc,'')");
    		}
			if(record.getPhoneNo()!=null&&StrUtil.isNotEmpty(record.getPhoneNo().toString())) {
    			 list.add("ifnull(phone_no,'')");
    		}
			if(record.getDefaultWay()!=null&&StrUtil.isNotEmpty(record.getDefaultWay().toString())) {
    			 list.add("ifnull(default_way,'')");
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
			if(record.getBankIcon()!=null&&StrUtil.isNotEmpty(record.getBankIcon().toString())) {
    			 list.add("ifnull(bank_icon,'')");
    		}
			if(record.getNo()!=null&&StrUtil.isNotEmpty(record.getNo().toString())) {
    			list2.add("'%"+record.getNo()+"%'");
    		}
			if(record.getPayeeWay()!=null&&StrUtil.isNotEmpty(record.getPayeeWay().toString())) {
    			list2.add("'%"+record.getPayeeWay()+"%'");
    		}
			if(record.getBankNm()!=null&&StrUtil.isNotEmpty(record.getBankNm().toString())) {
    			list2.add("'%"+record.getBankNm()+"%'");
    		}
			if(record.getBankCode()!=null&&StrUtil.isNotEmpty(record.getBankCode().toString())) {
    			list2.add("'%"+record.getBankCode()+"%'");
    		}
			if(record.getPayeeNm()!=null&&StrUtil.isNotEmpty(record.getPayeeNm().toString())) {
    			list2.add("'%"+record.getPayeeNm()+"%'");
    		}
			if(record.getPayeeAcc()!=null&&StrUtil.isNotEmpty(record.getPayeeAcc().toString())) {
    			list2.add("'%"+record.getPayeeAcc()+"%'");
    		}
			if(record.getPhoneNo()!=null&&StrUtil.isNotEmpty(record.getPhoneNo().toString())) {
    			list2.add("'%"+record.getPhoneNo()+"%'");
    		}
			if(record.getDefaultWay()!=null&&StrUtil.isNotEmpty(record.getDefaultWay().toString())) {
    			list2.add("'%"+record.getDefaultWay()+"%'");
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
			if(record.getBankIcon()!=null&&StrUtil.isNotEmpty(record.getBankIcon().toString())) {
    			list2.add("'%"+record.getBankIcon()+"%'");
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
    		list.add("ifnull(no,'')");
    		list.add("ifnull(payee_way,'')");
    		list.add("ifnull(bank_nm,'')");
    		list.add("ifnull(bank_code,'')");
    		list.add("ifnull(payee_nm,'')");
    		list.add("ifnull(payee_acc,'')");
    		list.add("ifnull(phone_no,'')");
    		list.add("ifnull(default_way,'')");
    		list.add("ifnull(create_by,'')");
    		list.add("ifnull(create_dat,'')");
    		list.add("ifnull(l_update_dat,'')");
    		list.add("ifnull(is_del,'')");
    		list.add("ifnull(bank_icon,'')");
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