package com.fc.ithink.model.auto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import cn.hutool.core.util.StrUtil;

/**
 * 作品证明表 ProCertificateExample
 * @author xy_自动生成
 * @date 2021-05-28 12:01:21
 */
public class ProCertificateExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProCertificateExample() {
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
        
				
        public Criteria andCertidIsNull() {
            addCriterion("certid is null");
            return (Criteria) this;
        }

        public Criteria andCertidIsNotNull() {
            addCriterion("certid is not null");
            return (Criteria) this;
        }

        public Criteria andCertidEqualTo(String value) {
            addCriterion("certid =", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidNotEqualTo(String value) {
            addCriterion("certid <>", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidGreaterThan(String value) {
            addCriterion("certid >", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidGreaterThanOrEqualTo(String value) {
            addCriterion("certid >=", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidLessThan(String value) {
            addCriterion("certid <", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidLessThanOrEqualTo(String value) {
            addCriterion("certid <=", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidLike(String value) {
            addCriterion("certid like", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidNotLike(String value) {
            addCriterion("certid not like", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidIn(List<String> values) {
            addCriterion("certid in", values, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidNotIn(List<String> values) {
            addCriterion("certid not in", values, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidBetween(String value1, String value2) {
            addCriterion("certid between", value1, value2, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidNotBetween(String value1, String value2) {
            addCriterion("certid not between", value1, value2, "certid");
            return (Criteria) this;
        }
        
				
        public Criteria andAppidIsNull() {
            addCriterion("appid is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("appid is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(String value) {
            addCriterion("appid =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(String value) {
            addCriterion("appid <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(String value) {
            addCriterion("appid >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(String value) {
            addCriterion("appid >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(String value) {
            addCriterion("appid <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(String value) {
            addCriterion("appid <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLike(String value) {
            addCriterion("appid like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotLike(String value) {
            addCriterion("appid not like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<String> values) {
            addCriterion("appid in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<String> values) {
            addCriterion("appid not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(String value1, String value2) {
            addCriterion("appid between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(String value1, String value2) {
            addCriterion("appid not between", value1, value2, "appid");
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
        
				
        public Criteria andClientInfoIsNull() {
            addCriterion("client_info is null");
            return (Criteria) this;
        }

        public Criteria andClientInfoIsNotNull() {
            addCriterion("client_info is not null");
            return (Criteria) this;
        }

        public Criteria andClientInfoEqualTo(String value) {
            addCriterion("client_info =", value, "clientInfo");
            return (Criteria) this;
        }

        public Criteria andClientInfoNotEqualTo(String value) {
            addCriterion("client_info <>", value, "clientInfo");
            return (Criteria) this;
        }

        public Criteria andClientInfoGreaterThan(String value) {
            addCriterion("client_info >", value, "clientInfo");
            return (Criteria) this;
        }

        public Criteria andClientInfoGreaterThanOrEqualTo(String value) {
            addCriterion("client_info >=", value, "clientInfo");
            return (Criteria) this;
        }

        public Criteria andClientInfoLessThan(String value) {
            addCriterion("client_info <", value, "clientInfo");
            return (Criteria) this;
        }

        public Criteria andClientInfoLessThanOrEqualTo(String value) {
            addCriterion("client_info <=", value, "clientInfo");
            return (Criteria) this;
        }

        public Criteria andClientInfoLike(String value) {
            addCriterion("client_info like", value, "clientInfo");
            return (Criteria) this;
        }

        public Criteria andClientInfoNotLike(String value) {
            addCriterion("client_info not like", value, "clientInfo");
            return (Criteria) this;
        }

        public Criteria andClientInfoIn(List<String> values) {
            addCriterion("client_info in", values, "clientInfo");
            return (Criteria) this;
        }

        public Criteria andClientInfoNotIn(List<String> values) {
            addCriterion("client_info not in", values, "clientInfo");
            return (Criteria) this;
        }

        public Criteria andClientInfoBetween(String value1, String value2) {
            addCriterion("client_info between", value1, value2, "clientInfo");
            return (Criteria) this;
        }

        public Criteria andClientInfoNotBetween(String value1, String value2) {
            addCriterion("client_info not between", value1, value2, "clientInfo");
            return (Criteria) this;
        }
        
				
        public Criteria andIpaddressIsNull() {
            addCriterion("ipaddress is null");
            return (Criteria) this;
        }

        public Criteria andIpaddressIsNotNull() {
            addCriterion("ipaddress is not null");
            return (Criteria) this;
        }

        public Criteria andIpaddressEqualTo(String value) {
            addCriterion("ipaddress =", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressNotEqualTo(String value) {
            addCriterion("ipaddress <>", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressGreaterThan(String value) {
            addCriterion("ipaddress >", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressGreaterThanOrEqualTo(String value) {
            addCriterion("ipaddress >=", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressLessThan(String value) {
            addCriterion("ipaddress <", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressLessThanOrEqualTo(String value) {
            addCriterion("ipaddress <=", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressLike(String value) {
            addCriterion("ipaddress like", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressNotLike(String value) {
            addCriterion("ipaddress not like", value, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressIn(List<String> values) {
            addCriterion("ipaddress in", values, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressNotIn(List<String> values) {
            addCriterion("ipaddress not in", values, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressBetween(String value1, String value2) {
            addCriterion("ipaddress between", value1, value2, "ipaddress");
            return (Criteria) this;
        }

        public Criteria andIpaddressNotBetween(String value1, String value2) {
            addCriterion("ipaddress not between", value1, value2, "ipaddress");
            return (Criteria) this;
        }
        
				
        public Criteria andSignatureIsNull() {
            addCriterion("signature is null");
            return (Criteria) this;
        }

        public Criteria andSignatureIsNotNull() {
            addCriterion("signature is not null");
            return (Criteria) this;
        }

        public Criteria andSignatureEqualTo(String value) {
            addCriterion("signature =", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotEqualTo(String value) {
            addCriterion("signature <>", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureGreaterThan(String value) {
            addCriterion("signature >", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("signature >=", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLessThan(String value) {
            addCriterion("signature <", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLessThanOrEqualTo(String value) {
            addCriterion("signature <=", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLike(String value) {
            addCriterion("signature like", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotLike(String value) {
            addCriterion("signature not like", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureIn(List<String> values) {
            addCriterion("signature in", values, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotIn(List<String> values) {
            addCriterion("signature not in", values, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureBetween(String value1, String value2) {
            addCriterion("signature between", value1, value2, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotBetween(String value1, String value2) {
            addCriterion("signature not between", value1, value2, "signature");
            return (Criteria) this;
        }
        
				
        public Criteria andSignStatusIsNull() {
            addCriterion("sign_status is null");
            return (Criteria) this;
        }

        public Criteria andSignStatusIsNotNull() {
            addCriterion("sign_status is not null");
            return (Criteria) this;
        }

        public Criteria andSignStatusEqualTo(String value) {
            addCriterion("sign_status =", value, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusNotEqualTo(String value) {
            addCriterion("sign_status <>", value, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusGreaterThan(String value) {
            addCriterion("sign_status >", value, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusGreaterThanOrEqualTo(String value) {
            addCriterion("sign_status >=", value, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusLessThan(String value) {
            addCriterion("sign_status <", value, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusLessThanOrEqualTo(String value) {
            addCriterion("sign_status <=", value, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusLike(String value) {
            addCriterion("sign_status like", value, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusNotLike(String value) {
            addCriterion("sign_status not like", value, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusIn(List<String> values) {
            addCriterion("sign_status in", values, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusNotIn(List<String> values) {
            addCriterion("sign_status not in", values, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusBetween(String value1, String value2) {
            addCriterion("sign_status between", value1, value2, "signStatus");
            return (Criteria) this;
        }

        public Criteria andSignStatusNotBetween(String value1, String value2) {
            addCriterion("sign_status not between", value1, value2, "signStatus");
            return (Criteria) this;
        }
        
				
        public Criteria andFilepathIsNull() {
            addCriterion("filepath is null");
            return (Criteria) this;
        }

        public Criteria andFilepathIsNotNull() {
            addCriterion("filepath is not null");
            return (Criteria) this;
        }

        public Criteria andFilepathEqualTo(String value) {
            addCriterion("filepath =", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotEqualTo(String value) {
            addCriterion("filepath <>", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathGreaterThan(String value) {
            addCriterion("filepath >", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathGreaterThanOrEqualTo(String value) {
            addCriterion("filepath >=", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLessThan(String value) {
            addCriterion("filepath <", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLessThanOrEqualTo(String value) {
            addCriterion("filepath <=", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLike(String value) {
            addCriterion("filepath like", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotLike(String value) {
            addCriterion("filepath not like", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathIn(List<String> values) {
            addCriterion("filepath in", values, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotIn(List<String> values) {
            addCriterion("filepath not in", values, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathBetween(String value1, String value2) {
            addCriterion("filepath between", value1, value2, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotBetween(String value1, String value2) {
            addCriterion("filepath not between", value1, value2, "filepath");
            return (Criteria) this;
        }
        
				
        public Criteria andSignTimIsNull() {
            addCriterion("sign_tim is null");
            return (Criteria) this;
        }

        public Criteria andSignTimIsNotNull() {
            addCriterion("sign_tim is not null");
            return (Criteria) this;
        }

        public Criteria andSignTimEqualTo(Date value) {
            addCriterion("sign_tim =", value, "signTim");
            return (Criteria) this;
        }

        public Criteria andSignTimNotEqualTo(Date value) {
            addCriterion("sign_tim <>", value, "signTim");
            return (Criteria) this;
        }

        public Criteria andSignTimGreaterThan(Date value) {
            addCriterion("sign_tim >", value, "signTim");
            return (Criteria) this;
        }

        public Criteria andSignTimGreaterThanOrEqualTo(Date value) {
            addCriterion("sign_tim >=", value, "signTim");
            return (Criteria) this;
        }

        public Criteria andSignTimLessThan(Date value) {
            addCriterion("sign_tim <", value, "signTim");
            return (Criteria) this;
        }

        public Criteria andSignTimLessThanOrEqualTo(Date value) {
            addCriterion("sign_tim <=", value, "signTim");
            return (Criteria) this;
        }

        public Criteria andSignTimLike(Date value) {
            addCriterion("sign_tim like", value, "signTim");
            return (Criteria) this;
        }

        public Criteria andSignTimNotLike(Date value) {
            addCriterion("sign_tim not like", value, "signTim");
            return (Criteria) this;
        }

        public Criteria andSignTimIn(List<Date> values) {
            addCriterion("sign_tim in", values, "signTim");
            return (Criteria) this;
        }

        public Criteria andSignTimNotIn(List<Date> values) {
            addCriterion("sign_tim not in", values, "signTim");
            return (Criteria) this;
        }

        public Criteria andSignTimBetween(Date value1, Date value2) {
            addCriterion("sign_tim between", value1, value2, "signTim");
            return (Criteria) this;
        }

        public Criteria andSignTimNotBetween(Date value1, Date value2) {
            addCriterion("sign_tim not between", value1, value2, "signTim");
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
        
				
        public Criteria andCreateTimIsNull() {
            addCriterion("create_tim is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimIsNotNull() {
            addCriterion("create_tim is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimEqualTo(Date value) {
            addCriterion("create_tim =", value, "createTim");
            return (Criteria) this;
        }

        public Criteria andCreateTimNotEqualTo(Date value) {
            addCriterion("create_tim <>", value, "createTim");
            return (Criteria) this;
        }

        public Criteria andCreateTimGreaterThan(Date value) {
            addCriterion("create_tim >", value, "createTim");
            return (Criteria) this;
        }

        public Criteria andCreateTimGreaterThanOrEqualTo(Date value) {
            addCriterion("create_tim >=", value, "createTim");
            return (Criteria) this;
        }

        public Criteria andCreateTimLessThan(Date value) {
            addCriterion("create_tim <", value, "createTim");
            return (Criteria) this;
        }

        public Criteria andCreateTimLessThanOrEqualTo(Date value) {
            addCriterion("create_tim <=", value, "createTim");
            return (Criteria) this;
        }

        public Criteria andCreateTimLike(Date value) {
            addCriterion("create_tim like", value, "createTim");
            return (Criteria) this;
        }

        public Criteria andCreateTimNotLike(Date value) {
            addCriterion("create_tim not like", value, "createTim");
            return (Criteria) this;
        }

        public Criteria andCreateTimIn(List<Date> values) {
            addCriterion("create_tim in", values, "createTim");
            return (Criteria) this;
        }

        public Criteria andCreateTimNotIn(List<Date> values) {
            addCriterion("create_tim not in", values, "createTim");
            return (Criteria) this;
        }

        public Criteria andCreateTimBetween(Date value1, Date value2) {
            addCriterion("create_tim between", value1, value2, "createTim");
            return (Criteria) this;
        }

        public Criteria andCreateTimNotBetween(Date value1, Date value2) {
            addCriterion("create_tim not between", value1, value2, "createTim");
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
        
			
		 public Criteria andLikeQuery(ProCertificate record) {
		 	List<String> list= new ArrayList<String>();
		 	List<String> list2= new ArrayList<String>();
        	StringBuffer buffer=new StringBuffer();
			if(record.getCertid()!=null&&StrUtil.isNotEmpty(record.getCertid().toString())) {
    			 list.add("ifnull(certid,'')");
    		}
			if(record.getAppid()!=null&&StrUtil.isNotEmpty(record.getAppid().toString())) {
    			 list.add("ifnull(appid,'')");
    		}
			if(record.getProNo()!=null&&StrUtil.isNotEmpty(record.getProNo().toString())) {
    			 list.add("ifnull(pro_no,'')");
    		}
			if(record.getClientInfo()!=null&&StrUtil.isNotEmpty(record.getClientInfo().toString())) {
    			 list.add("ifnull(client_info,'')");
    		}
			if(record.getIpaddress()!=null&&StrUtil.isNotEmpty(record.getIpaddress().toString())) {
    			 list.add("ifnull(ipaddress,'')");
    		}
			if(record.getSignature()!=null&&StrUtil.isNotEmpty(record.getSignature().toString())) {
    			 list.add("ifnull(signature,'')");
    		}
			if(record.getSignStatus()!=null&&StrUtil.isNotEmpty(record.getSignStatus().toString())) {
    			 list.add("ifnull(sign_status,'')");
    		}
			if(record.getFilepath()!=null&&StrUtil.isNotEmpty(record.getFilepath().toString())) {
    			 list.add("ifnull(filepath,'')");
    		}
			if(record.getSignTim()!=null&&StrUtil.isNotEmpty(record.getSignTim().toString())) {
    			 list.add("ifnull(sign_tim,'')");
    		}
			if(record.getCreateBy()!=null&&StrUtil.isNotEmpty(record.getCreateBy().toString())) {
    			 list.add("ifnull(create_by,'')");
    		}
			if(record.getCreateDat()!=null&&StrUtil.isNotEmpty(record.getCreateDat().toString())) {
    			 list.add("ifnull(create_dat,'')");
    		}
			if(record.getCreateTim()!=null&&StrUtil.isNotEmpty(record.getCreateTim().toString())) {
    			 list.add("ifnull(create_tim,'')");
    		}
			if(record.getLUpdateDat()!=null&&StrUtil.isNotEmpty(record.getLUpdateDat().toString())) {
    			 list.add("ifnull(l_update_dat,'')");
    		}
			if(record.getIsDel()!=null&&StrUtil.isNotEmpty(record.getIsDel().toString())) {
    			 list.add("ifnull(is_del,'')");
    		}
			if(record.getCertid()!=null&&StrUtil.isNotEmpty(record.getCertid().toString())) {
    			list2.add("'%"+record.getCertid()+"%'");
    		}
			if(record.getAppid()!=null&&StrUtil.isNotEmpty(record.getAppid().toString())) {
    			list2.add("'%"+record.getAppid()+"%'");
    		}
			if(record.getProNo()!=null&&StrUtil.isNotEmpty(record.getProNo().toString())) {
    			list2.add("'%"+record.getProNo()+"%'");
    		}
			if(record.getClientInfo()!=null&&StrUtil.isNotEmpty(record.getClientInfo().toString())) {
    			list2.add("'%"+record.getClientInfo()+"%'");
    		}
			if(record.getIpaddress()!=null&&StrUtil.isNotEmpty(record.getIpaddress().toString())) {
    			list2.add("'%"+record.getIpaddress()+"%'");
    		}
			if(record.getSignature()!=null&&StrUtil.isNotEmpty(record.getSignature().toString())) {
    			list2.add("'%"+record.getSignature()+"%'");
    		}
			if(record.getSignStatus()!=null&&StrUtil.isNotEmpty(record.getSignStatus().toString())) {
    			list2.add("'%"+record.getSignStatus()+"%'");
    		}
			if(record.getFilepath()!=null&&StrUtil.isNotEmpty(record.getFilepath().toString())) {
    			list2.add("'%"+record.getFilepath()+"%'");
    		}
			if(record.getSignTim()!=null&&StrUtil.isNotEmpty(record.getSignTim().toString())) {
    			list2.add("'%"+record.getSignTim()+"%'");
    		}
			if(record.getCreateBy()!=null&&StrUtil.isNotEmpty(record.getCreateBy().toString())) {
    			list2.add("'%"+record.getCreateBy()+"%'");
    		}
			if(record.getCreateDat()!=null&&StrUtil.isNotEmpty(record.getCreateDat().toString())) {
    			list2.add("'%"+record.getCreateDat()+"%'");
    		}
			if(record.getCreateTim()!=null&&StrUtil.isNotEmpty(record.getCreateTim().toString())) {
    			list2.add("'%"+record.getCreateTim()+"%'");
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
    		list.add("ifnull(certid,'')");
    		list.add("ifnull(appid,'')");
    		list.add("ifnull(pro_no,'')");
    		list.add("ifnull(client_info,'')");
    		list.add("ifnull(ipaddress,'')");
    		list.add("ifnull(signature,'')");
    		list.add("ifnull(sign_status,'')");
    		list.add("ifnull(filepath,'')");
    		list.add("ifnull(sign_tim,'')");
    		list.add("ifnull(create_by,'')");
    		list.add("ifnull(create_dat,'')");
    		list.add("ifnull(create_tim,'')");
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