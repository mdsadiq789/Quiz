package com.fibr.quiz.utils;



import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StringWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONBUserType implements UserType {
    public JSONBUserType() {
    }

    public int[] sqlTypes() {
        return new int[]{2000};
    }

    @Override
    public int getSqlType() {
        return 0;
    }

    public Class<?> returnedClass() {
        return JSONObject.class;
    }

    public Object deepCopy(Object value) throws HibernateException {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(value);
            oos.flush();
            oos.close();
            bos.close();
            ByteArrayInputStream bais = new ByteArrayInputStream(bos.toByteArray());
            return (new ObjectInputStream(bais)).readObject();
        } catch (IOException | ClassNotFoundException var5) {
            throw new HibernateException(var5);
        }
    }

    public boolean isMutable() {
        return true;
    }

    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable)this.deepCopy(value);
    }

    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return this.deepCopy(cached);
    }

    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return this.deepCopy(original);
    }

    public boolean equals(Object obj1, Object obj2) throws HibernateException {
        if (obj1 == null) {
            return obj2 == null;
        } else {
            return obj1.equals(obj2);
        }
    }

    public int hashCode(Object obj) throws HibernateException {
        return obj.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet, int i, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws SQLException {
        return null;
    }

    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        String cellContent = rs.getString(names[0]);
        if (cellContent == null) {
            return null;
        } else {
            try {
                JSONParser parser = new JSONParser();
                JSONObject jsonObject = (JSONObject)parser.parse(cellContent);
                return jsonObject;
            } catch (Exception var8) {
                throw new RuntimeException("Failed to convert PostgreSQL jsonb to JSONObject : " + var8.getMessage(), var8);
            }
        }
    }

    public void nullSafeSet(PreparedStatement ps, Object value, int idx, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        if (value == null) {
            ps.setNull(idx, 1111);
        } else {
            try {
                ObjectMapper mapper = new ObjectMapper();
                StringWriter w = new StringWriter();
                mapper.writeValue(w, value);
                w.flush();
                ps.setObject(idx, w.toString(), 1111);
            } catch (Exception var7) {
                throw new RuntimeException("Failed to convert Invoice to String: " + var7.getMessage(), var7);
            }
        }
    }
}
