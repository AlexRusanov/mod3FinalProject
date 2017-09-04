package eparliament.dao.mock;

import eparliament.dao.DeputyDao;
import eparliament.domain.Deputy;
import eparliament.domain.Gender;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by alexandrrusanov on 26/8/17.
 */
public class DeputyDaoMock implements DeputyDao {

    private List<Deputy> deputyStorage;

    @Override
    public List<Deputy> getAll() {
        return null;
    }

    @Override
    public Optional<Deputy> getById(int deputyId) {
        return null;
    }

    @Override
    public Deputy save(Deputy deputy) {
        return null;
    }

    @Override
    public boolean delete(int deputyId) {
        return false;
    }

    public void initDeputyStorage(){
        deputyStorage = new ArrayList<>();

        deputyStorage.add(new Deputy("Петя",
                "Шоколадный",
                Gender.MALE,
                LocalDateTime.of(1956, 12, 28, 0, 0, 0),
                "Кондитерская"));

        deputyStorage.add(new Deputy("Юра",
                "Закон",
                Gender.MALE,
                LocalDateTime.of(1958, 5, 13, 0, 0, 0),
                "Кондитерская"));

        deputyStorage.add(new Deputy("Олег",
                "Радикальный",
                Gender.MALE,
                LocalDateTime.of(1970, 6, 3, 0, 0, 0),
                "Вилы на изготовку"));

        deputyStorage.add(new Deputy("Юля",
                "Роботяща",
                Gender.FEMALE,
                LocalDateTime.of(1969, 8, 23, 0, 0, 0),
                "Сердешные"));

        deputyStorage.add(new Deputy("Саша",
                "Пастор",
                Gender.MALE,
                LocalDateTime.of(1964, 10, 15, 0, 0, 0),
                "Сердешные"));
    }
}
