from statistics import mean


class Lists:

    def __init__(self, a_list: list, b_list: list):
        self.a = a_list
        self.b = b_list

    def average_lists(self):
        if not isinstance(self.a, list) or not isinstance(self.b, list):
            raise TypeError("Not a list")
        avg_a = mean(self.a)
        avg_b = mean(self.b)

        return [avg_a, avg_b]

    @staticmethod
    def comparison_lists(list_avg):
        if list_avg[0] > list_avg[1]:
            return "Первый список имеет большее среднее значение"
        elif list_avg[0] < list_avg[1]:
            return "Второй список имеет большее среднее значение"
        else:
            return "Средние значения равны"
