package bitcamp.myapp.mybatis;

import org.apache.ibatis.session.*;

import java.sql.Connection;

public class SqlSessionFactoryProxy implements SqlSessionFactory {

    SqlSessionFactory original;

    // SqlSession 객체를 담을 스레드 전용 변수
    ThreadLocal<SqlSession> sqlSessionThreadLocal = new ThreadLocal<>();

    public SqlSessionFactoryProxy(SqlSessionFactory original) {
        this.original = original;
    }

    @Override
    public SqlSession openSession() {
        return original.openSession();
    }

    @Override
    public SqlSession openSession(boolean autoCommit) {
        // 스레드 별도 한 개의 SqlSession 객체를 생성해줌
        // 1) 스레드 저장소에서 SqlSession 객체를 찾는다.
        SqlSession sqlSession = sqlSessionThreadLocal.get();

        // 2) 없으면, 오리지널 객체를 통해 새로 얻는다.
        if (sqlSession == null) {
            //    - 오리지널 객체를 통해 새로 얻는다.
            sqlSession = original.openSession(autoCommit);
            //    - 스레드 보관소에 저장한다.
            sqlSessionThreadLocal.set(sqlSession);
            //    - 새로 만든 SqlSession 객체를 리턴한다.
        }
        return sqlSession;
    }

    // 3) 있으면,
    //    - 해당 스레드의 SqlSession 객체를 리턴한다.


    @Override
    public SqlSession openSession(Connection connection) {
        return original.openSession(connection);
    }

    @Override
    public SqlSession openSession(TransactionIsolationLevel level) {
        return original.openSession(level);
    }

    @Override
    public SqlSession openSession(ExecutorType execType) {
        return original.openSession(execType);
    }

    @Override
    public SqlSession openSession(ExecutorType execType, boolean autoCommit) {
        return original.openSession(execType, autoCommit);
    }

    @Override
    public SqlSession openSession(ExecutorType execType, TransactionIsolationLevel level) {
        return original.openSession(execType, level);
    }

    @Override
    public SqlSession openSession(ExecutorType execType, Connection connection) {
        return original.openSession(execType, connection);
    }

    @Override
    public Configuration getConfiguration() {
        return original.getConfiguration();
    }
}
