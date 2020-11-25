package chapter06.repositories;

import chapter06.MyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long> {
    public MyData findByid(Long name);  // 왜인지 모르겠는데 Id로 하면 오류뜨고 id 해야함 (MyData의 id와 무관)
    public List<MyData> findByNameLike(String name);
    public List<MyData> findByIdIsNotNullOrderByIdDesc();
    public List<MyData> findByAgeGreaterThan(Integer age);
    public List<MyData> findByAgeBetween(Integer age1, Integer age2);
}
