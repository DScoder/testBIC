# testBIC
collections + BD

На данный момент оптимизировать алгоритм удалось незначительно. 
Время обработки и группировки .CSV файла растет экспоненциально количеству записей. 
Результирующее сообщение после обработки 20к записей выглядит так:

Create csvData: 83 ms
Grouping of 20000 records ready in: 18222 ms

Group info:
Groups size: 19999
Group number 15891 have 2 same results:
"83657889521""100000052393488""200000391972049"
"83004246466""100000052393488""200000292513054"

Распаралелливание и дальнейшая оптимизация не дадут нужный результат. Учу Hadoop и Spark.