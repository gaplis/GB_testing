package homeworks.homeworkTwo.main;

public class Main {

    /*
     Домашнее задание к семинару №2 JUnit:
     1. Настроить новый проект:
         a). Нужно создать новый проект, с представленной структурой классов
         b). Настроить тестовую среду
             (создать тестовый класс VehicleTest, пометить папку как Test sources (зеленая папка),
             импортировать необходимые для тестов библиотеки (JUnit, assertJ - все что было на семинаре))
         c). Написать следующие тесты:
             - проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
             - проверка того, объект Car создается с 4-мя колесами
             - проверка того, объект Motorcycle создается с 2-мя колесами
             - проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
             - проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
             - проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)
             - проверить, что в режиме парковки (сначала testDrive, потом park  т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)

        В этом проекте, вы будете работать с проектом ""Vehicle"", который представляет собой иерархию классов,
    включающую абстрактный базовый класс ""Vehicle"" и два его подкласса ""Car"" и ""Motorcycle"".

        Базовый класс ""Vehicle"" содержит абстрактные методы ""testDrive()"" и ""park()"",
    а также поля ""company"", ""model"", ""yearRelease"", ""numWheels"" и ""speed"".

        Класс ""Car"" расширяет ""Vehicle"" и реализует его абстрактные методы. При создании объекта ""Car"", число колес устанавливается в 4,
    а скорость в 0. В методе ""testDrive()"" скорость устанавливается на 60, а в методе ""park()"" - обратно в 0.

        Класс ""Motorcycle"" также расширяет ""Vehicle"" и реализует его абстрактные методы.
    При создании объекта ""Motorcycle"", число колес устанавливается в 2, а скорость в 0. В методе ""testDrive()"" скорость устанавливается на 75, а в методе ""park()"" - обратно в 0.
    */
}