## Task5

---
Let the key of Map is project name and value contains list of participants.

---
Create a Stream\<String\> nameList(Map\<String, Stream\<String\>\> map) method 
of the MyUtils class to build sorted stream of all participants without duplication.

---
Please ignore null or empty strings, extra spaces and case sensitivity.
Throw NullPointerException if map is null.

---
For example, for a given map
```json
 {"Desktop":[" iVan", "PeTro ", " Ira "], 
  "Web":["STepan", "ira ", " Andriy ", "an na"], 
  "Spring":["Ivan", "Anna"]}
```

---
you should get
```json
["Andriy", "Anna", "Ira", "Ivan", "Petro ", "Stepan"]
```

---
### When you will paste code to Moodle, paste class MyUtils and method
