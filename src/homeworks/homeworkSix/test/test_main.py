# Задание 1. Создайте программу на Python или Java, которая принимает два списка чисел и выполняет следующие действия:
# a. Рассчитывает среднее значение каждого списка.
# b. Сравнивает эти средние значения и выводит соответствующее сообщение:
# - ""Первый список имеет большее среднее значение"", если среднее значение первого списка больше.
# - ""Второй список имеет большее среднее значение"", если среднее значение второго списка больше.
# - ""Средние значения равны"", если средние значения списков равны.
#
# Важно:
# Приложение должно быть написано в соответствии с принципами объектно-ориентированного программирования.
# Используйте Pytest (для Python) или JUnit (для Java) для написания тестов, которые проверяют правильность
# работы программы. Тесты должны учитывать различные сценарии использования вашего приложения.
# Используйте pylint (для Python) или Checkstyle (для Java) для проверки качества кода.
# Сгенерируйте отчет о покрытии кода тестами. Ваша цель - достичь минимум 90% покрытия.

import pytest

from src.homeworks.homeworkSix.main.main import Lists


@pytest.fixture
def data_average_lists_type_error():
    return Lists(3, [3, 4, 5])


def test_average_lists_type_error(data_average_lists_type_error):
    with pytest.raises(TypeError):
        data_average_lists_type_error.average_lists()


@pytest.fixture
def data_average_lists():
    return Lists([3, 4, 5], [3, 7, 5])


def test_average_lists(data_average_lists):
    assert data_average_lists.average_lists() == [4, 5]


@pytest.mark.parametrize("avg_lists, expected", [
    ([10, 5], "Первый список имеет большее среднее значение"),
    ([5, 10], "Второй список имеет большее среднее значение"),
    ([10, 10], "Средние значения равны"),
])
def test_comparison_lists(avg_lists, expected):
    assert Lists.comparison_lists(avg_lists) == expected


if __name__ == '__main__':
    pytest.main()
