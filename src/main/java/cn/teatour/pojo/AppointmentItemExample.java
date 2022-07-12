package cn.teatour.pojo;

import java.util.ArrayList;
import java.util.List;

public class AppointmentItemExample {
    protected String appointmentByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppointmentItemExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setAppointmentByClause(String appointmentByClause) {
        this.appointmentByClause = appointmentByClause;
    }

    public String getAppointmentByClause() {
        return appointmentByClause;
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
        appointmentByClause = null;
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

        public Criteria andTeaGarden_idIsNull() {
            addCriterion("teaGarden_id is null");
            return (Criteria) this;
        }

        public Criteria andTeaGarden_idIsNotNull() {
            addCriterion("teaGarden_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeaGarden_idEqualTo(Integer value) {
            addCriterion("teaGarden_id =", value, "teaGarden_id");
            return (Criteria) this;
        }

        public Criteria andTeaGarden_idNotEqualTo(Integer value) {
            addCriterion("teaGarden_id <>", value, "teaGarden_id");
            return (Criteria) this;
        }

        public Criteria andTeaGarden_idGreaterThan(Integer value) {
            addCriterion("teaGarden_id >", value, "teaGarden_id");
            return (Criteria) this;
        }

        public Criteria andTeaGarden_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("teaGarden_id >=", value, "teaGarden_id");
            return (Criteria) this;
        }

        public Criteria andTeaGarden_idLessThan(Integer value) {
            addCriterion("teaGarden_id <", value, "teaGarden_id");
            return (Criteria) this;
        }

        public Criteria andTeaGarden_idLessThanOrEqualTo(Integer value) {
            addCriterion("teaGarden_id <=", value, "teaGarden_id");
            return (Criteria) this;
        }

        public Criteria andTeaGarden_idIn(List<Integer> values) {
            addCriterion("teaGarden_id in", values, "teaGarden_id");
            return (Criteria) this;
        }

        public Criteria andTeaGarden_idNotIn(List<Integer> values) {
            addCriterion("teaGarden_id not in", values, "teaGarden_id");
            return (Criteria) this;
        }

        public Criteria andTeaGarden_idBetween(Integer value1, Integer value2) {
            addCriterion("teaGarden_id between", value1, value2, "teaGarden_id");
            return (Criteria) this;
        }

        public Criteria andTeaGarden_idNotBetween(Integer value1, Integer value2) {
            addCriterion("teaGarden_id not between", value1, value2, "teaGarden_id");
            return (Criteria) this;
        }

        public Criteria andAppointment_idIsNull() {
            addCriterion("appointment_id is null");
            return (Criteria) this;
        }

        public Criteria andAppointment_idIsNotNull() {
            addCriterion("appointment_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppointment_idEqualTo(Integer value) {
            addCriterion("appointment_id =", value, "appointment_id");
            return (Criteria) this;
        }

        public Criteria andAppointment_idNotEqualTo(Integer value) {
            addCriterion("appointment_id <>", value, "appointment_id");
            return (Criteria) this;
        }

        public Criteria andAppointment_idGreaterThan(Integer value) {
            addCriterion("appointment_id >", value, "appointment_id");
            return (Criteria) this;
        }

        public Criteria andAppointment_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("appointment_id >=", value, "appointment_id");
            return (Criteria) this;
        }

        public Criteria andAppointment_idLessThan(Integer value) {
            addCriterion("appointment_id <", value, "appointment_id");
            return (Criteria) this;
        }

        public Criteria andAppointment_idLessThanOrEqualTo(Integer value) {
            addCriterion("appointment_id <=", value, "appointment_id");
            return (Criteria) this;
        }

        public Criteria andAppointment_idIn(List<Integer> values) {
            addCriterion("appointment_id in", values, "appointment_id");
            return (Criteria) this;
        }

        public Criteria andAppointment_idNotIn(List<Integer> values) {
            addCriterion("appointment_id not in", values, "appointment_id");
            return (Criteria) this;
        }

        public Criteria andAppointment_idBetween(Integer value1, Integer value2) {
            addCriterion("appointment_id between", value1, value2, "appointment_id");
            return (Criteria) this;
        }

        public Criteria andAppointment_idNotBetween(Integer value1, Integer value2) {
            addCriterion("appointment_id not between", value1, value2, "appointment_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUser_idEqualTo(Integer value) {
            addCriterion("user_id =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThan(Integer value) {
            addCriterion("user_id >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThan(Integer value) {
            addCriterion("user_id <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIn(List<Integer> values) {
            addCriterion("user_id in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
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