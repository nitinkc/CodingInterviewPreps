# Calendar Matching

**Category:** Arrays

```
## Problem Statement

Calendar Matching
Imagine that you want to schedule a meeting of a certain duration with a co-worker. You have access to your calendar and your co-worker's calendar (both of which contain
your respective meetings for the day, in the form of [startTime, endTime] ), as well as both of your daily bounds (i.e., the earliest and latest times at which you're
available for meetings every day, in the form of [earliestTime, latestTime] ).
Write a function that takes in your calendar, your daily bounds, your co-worker's calendar, your co-worker's daily bounds, and the duration of the meeting that you want to
schedule, and that returns a list of all the time blocks (in the form of [startTime, endTime] ) during which you could schedule the meeting, ordered from earliest time
block to latest.
Note that times will be given and should be returned in military time. For example: 8:30 , 9:01 , and 23:56 .
Sample Input
calendar1 = [['9:00', '10:30'], ['12:00', '13:00'], ['16:00', '18:00']]
dailyBounds1 = ['9:00', '20:00']
calendar2 = [['10:00', '11:30'], ['12:30', '14:30'], ['14:30', '15:00'], ['16:00', '17:00']]
dailyBounds2 = ['10:00', '18:30']
meetingDuration = 30
Sample Output
[['11:30', '12:00'], ['15:00', '16:00'], ['18:00', '18:30']]
Hints
Hint 1
In order to nd blocks of time during which you and your coworker can have a meeting, you have to rst nd all of the unavailabilities between the two of you. An
unavailability is any block of time during which at least one of you is busy.
Hint 2
You'll have to start by taking into account the daily bounds; the daily bounds can be represented by two additional meetings in each of your calendars.
Hint 3
Once you've taken the daily bounds into account, you'll want to merge the two calendars into a single calendar of meetings and then atten that calendar in order to
eliminate overlapping and back-to-back meetings. This will give you a calendar of unavailabilities, from which you can pretty easily nd the list of matching
availabilities.
Optimal Space & Time Complexity
O(c1 + c2) time | O(c1 + c2) space - where c1 and c2 are the respective numbers of meetings in calendar1 and calendar2

```
---

## Approach & Solution

### Solution 1

Our Solution(s) Run Code Tests
76 List<Meeting> matchingAvailabilities = new ArrayList<Meeting>();
77 ▾ for (int i = 1; i < calendar.size(); i++) {
78 int start = calendar.get(i - 1).end;
79 int end = calendar.get(i).start;
80 int availabilityDuration = end - start;
81 ▾ if (availabilityDuration >= meetingDuration) {
82 matchingAvailabilities.add(new Meeting(start, end));
83 }
84 }
85 List<StringMeeting> matchingAvailabilitiesInHours = new ArrayList<StringMeeting
86 ▾ for (int i = 0; i < matchingAvailabilities.size(); i++) {
87 matchingAvailabilitiesInHours.add(
88 new StringMeeting(
89 minutesToTime(matchingAvailabilities.get(i).start),
90 minutesToTime(matchingAvailabilities.get(i).end))); Custom Output Submit Code
91 }
92 return matchingAvailabilitiesInHours;
93 }
Yay, our code passed all the test cases!
94
95 ▾ public static int timeToMinutes(String time) {
96 int delimiterPos = time.indexOf(":");
97 int hours = Integer.parseInt(time.substring(0, delimiterPos));
Test Case 1 passed!
98 int minutes = Integer.parseInt(time.substring(delimiterPos + 1, time.length()))
99 return hours * 60 + minutes;
100 }
101 Our Code's Output
102 ▾ public static String minutesToTime(int minutes) {
103 int hours = minutes / 60;
104 int mins = minutes % 60; 1 [["11:30", "12:00"], ["15:00", "16:00"], ["18:00", "18:30"]]
105 String hoursString = Integer.toString(hours);
106 String minutesString = mins < 10 ? "0" + Integer.toString(mins) : Integer.toStr
Input(s)
107 return hoursString + ":" + minutesString;
108 }
1 {
109
2 "calendar1": [["9:00", "10:30"], ["12:00", "13:00"], ["16:00", "18:00
110 ▾ static class StringMeeting {
3 "calendar2": [
111 public String start;
4 ["10:00", "11:30"],
112 public String end;
5 ["12:30", "14:30"],
113
6 ["14:30", "15:00"],
114 ▾ public StringMeeting(String start, String end) {
7 ["16:00", "17:00"]
115 this.start = start;
8 ],
116 this.end = end;
9 "dailyBounds1": ["9:00", "20:00"],
117 }
10 "dailyBounds2": ["10:00", "18:30"],
118 }
11 "meetingDuration": 30
119
12 }
120 ▾ static class Meeting {
121 public int start;
122 public int end;
123
124 ▾ public Meeting(int start, int end) {
125 this.start = start; Test Case 2 passed!
126 this.end = end;
127 }
Our Code's Output
128 }
129 }
1 [["11:30", "12:00"], ["15:00", "16:00"], ["18:00", "18:30"]]

### Solution 2

Our Solution(s) Run Code Tests
44 ▾ if (meeting1.start < meeting2.start) {
45 merged.add(meeting1);
46 i++;
47 ▾ } else {
48 merged.add(meeting2);
49 j++;
50 }
51 }
52 while (i < calendar1.size()) merged.add(calendar1.get(i++));
53 while (j < calendar2.size()) merged.add(calendar2.get(j++));
54 return merged;
55 }
56
57 ▾ public static List<Meeting> flattenCalendar(List<Meeting> calendar) {
58 List<Meeting> flattened = new ArrayList<Meeting>();
59 flattened.add(calendar.get(0));
60 ▾ for (int i = 1; i < calendar.size(); i++) {
61 Meeting currentMeeting = calendar.get(i);
62 Meeting previousMeeting = flattened.get(flattened.size() - 1);
63 ▾ if (previousMeeting.end >= currentMeeting.start) {
64 Meeting newPreviousMeeting =
65 new Meeting(previousMeeting.start, Math.max(previousMeeting.end, curren
66 flattened.set(flattened.size() - 1, newPreviousMeeting);
67 ▾ } else {
68 flattened.add(currentMeeting);
69 }
70 }
71 return flattened;
72 }
73
74 public static List<StringMeeting> getMatchingAvailabilities(
75 ▾ List<Meeting> calendar, int meetingDuration) {
76 List<Meeting> matchingAvailabilities = new ArrayList<Meeting>();
77 ▾ for (int i = 1; i < calendar.size(); i++) {
78 int start = calendar.get(i - 1).end;
79 int end = calendar.get(i).start;
80 int availabilityDuration = end - start;
81 ▾ if (availabilityDuration >= meetingDuration) {
82 matchingAvailabilities.add(new Meeting(start, end)); Custom Output Submit Code
83 }
84 }
85 List<StringMeeting> matchingAvailabilitiesInHours = new ArrayList<StringMeeting Yay, our code passed all the test cases!
Test Case 1 passed!
Our Code's Output
1 [["11:30", "12:00"], ["15:00", "16:00"], ["18:00", "18:30"]]
Input(s)
1 {
2 "calendar1": [["9:00", "10:30"], ["12:00", "13:00"], ["16:00", "18:00
3 "calendar2": [
4 ["10:00", "11:30"],
5 ["12:30", "14:30"],
6 ["14:30", "15:00"],
7 ["16:00", "17:00"]
8 ],
9 "dailyBounds1": ["9:00", "20:00"],
10 "dailyBounds2": ["10:00", "18:30"],
11 "meetingDuration": 30
12 }
Test Case 2 passed!
Our Code's Output
1 [["11:30", "12:00"], ["15:00", "16:00"], ["18:00", "18:30"]]

### Solution 3

```
}
while (i < calendar1.size()) merged.add(calendar1.get(i++));
while (j < calendar2.size()) merged.add(calendar2.get(j++));
return merged;
}
public static List<Meeting> flattenCalendar(List<Meeting> calendar) {
List<Meeting> flattened = new ArrayList<Meeting>();
flattened.add(calendar.get(0));
for (int i = 1; i < calendar.size(); i++) {
Meeting currentMeeting = calendar.get(i);
Meeting previousMeeting = flattened.get(flattened.size() - 1);
if (previousMeeting.end >= currentMeeting.start) {
Meeting newPreviousMeeting =
new Meeting(previousMeeting.start, Math.max(previousMeeting.end, currentMeeting.end));
flattened.set(flattened.size() - 1, newPreviousMeeting);
} else {
flattened.add(currentMeeting);
}
}
return flattened;
}
public static List<StringMeeting> getMatchingAvailabilities(
List<Meeting> calendar, int meetingDuration) {
List<Meeting> matchingAvailabilities = new ArrayList<Meeting>();
for (int i = 1; i < calendar.size(); i++) {
int start = calendar.get(i - 1).end;
int end = calendar.get(i).start;
int availabilityDuration = end - start;
if (availabilityDuration >= meetingDuration) {
matchingAvailabilities.add(new Meeting(start, end));
}
}
List<StringMeeting> matchingAvailabilitiesInHours = new ArrayList<StringMeeting>();
for (int i = 0; i < matchingAvailabilities.size(); i++) {
matchingAvailabilitiesInHours.add(
new StringMeeting(
minutesToTime(matchingAvailabilities.get(i).start),
minutesToTime(matchingAvailabilities.get(i).end)));
}
return matchingAvailabilitiesInHours;
}
public static int timeToMinutes(String time) {
int delimiterPos = time indexOf(":");
int delimiterPos = time.indexOf( : );
int hours = Integer.parseInt(time.substring(0, delimiterPos));
int minutes = Integer.parseInt(time.substring(delimiterPos + 1, time.length()));
return hours * 60 + minutes;
}
public static String minutesToTime(int minutes) {
int hours = minutes / 60;
int mins = minutes % 60;
String hoursString = Integer.toString(hours);
String minutesString = mins < 10 ? "0" + Integer.toString(mins) : Integer.toString(mins);
return hoursString + ":" + minutesString;

### Solution 4

Our Solution(s) Run Code Tests
▾import java.util.*;
▾class Program {
// O(c1 + c2) time | O(c1 + c2) space - where c1 and c2 are the respective numbers
// in calendar1 and calendar2
public static List<StringMeeting> calendarMatching(
List<StringMeeting> calendar1,
StringMeeting dailyBounds1,
List<StringMeeting> calendar2,
StringMeeting dailyBounds2,
▾ int meetingDuration) {
List<Meeting> updatedCalendar1 = updateCalendar(calendar1, dailyBounds1);
List<Meeting> updatedCalendar2 = updateCalendar(calendar2, dailyBounds2);
List<Meeting> mergedCalendar = mergeCalendars(updatedCalendar1, updatedCalendar2
List<Meeting> flattenedCalendar = flattenCalendar(mergedCalendar);
return getMatchingAvailabilities(flattenedCalendar, meetingDuration);
}
public static List<Meeting> updateCalendar(
▾ List<StringMeeting> calendar, StringMeeting dailyBounds) {
List<StringMeeting> updatedCalendar = new ArrayList<StringMeeting>();
updatedCalendar.add(new StringMeeting("0:00", dailyBounds.start));
updatedCalendar.addAll(calendar);
updatedCalendar.add(new StringMeeting(dailyBounds.end, "23:59"));
List<Meeting> calendarInMinutes = new ArrayList<Meeting>();
▾ for (int i = 0; i < updatedCalendar.size(); i++) {
calendarInMinutes.add(
new Meeting(
timeToMinutes(updatedCalendar.get(i).start),
timeToMinutes(updatedCalendar.get(i).end)));
}
return calendarInMinutes;
}
▾ public static List<Meeting> mergeCalendars(List<Meeting> calendar1, List<Meeting>
List<Meeting> merged = new ArrayList<Meeting>();
int i = 0; Custom Output Submit Code
int j = 0;
▾ while (i < calendar1.size() && j < calendar2.size()) {
Meeting meeting1 = calendar1.get(i); Yay, our code passed all the test cases!
Meeting meeting2 = calendar2.get(j);
▾ if (meeting1.start < meeting2.start) {
merged.add(meeting1);
i++; Test Case 1 passed!
▾ } else {
merged.add(meeting2);
j++;
Our Code's Output
}
}
[["11:30", "12:00"], ["15:00", "16:00"], ["18:00", "18:30"]]
while (i < calendar1.size()) merged.add(calendar1.get(i++));
while (j < calendar2.size()) merged.add(calendar2.get(j++));
return merged;
Input(s)
}
{
▾ public static List<Meeting> flattenCalendar(List<Meeting> calendar) {
"calendar1": [["9:00", "10:30"], ["12:00", "13:00"], ["16:00", "18:00
"calendar2": [
["10:00", "11:30"],
["12:30", "14:30"],
["14:30", "15:00"],
["16:00", "17:00"]
],
"dailyBounds1": ["9:00", "20:00"],
"dailyBounds2": ["10:00", "18:30"],
"meetingDuration": 30
}
Test Case 2 passed!
Our Code's Output
[["11:30", "12:00"], ["15:00", "16:00"], ["18:00", "18:30"]]

### Solution 5

```
91 }
92 return matchingAvailabilitiesInHours;
93 }
94
95 public static int timeToMinutes(String time) {
96 int delimiterPos = time.indexOf(":");
97 int hours = Integer.parseInt(time.substring(0, delimiterPos));
98 int minutes = Integer.parseInt(time.substring(delimiterPos + 1, time.length()));
99 return hours * 60 + minutes;
100 }
101
102 public static String minutesToTime(int minutes) {
103 int hours = minutes / 60;
104 int mins = minutes % 60;
105 String hoursString = Integer.toString(hours);
106 String minutesString = mins < 10 ? "0" + Integer.toString(mins) : Integer.toString(mins);
107 return hoursString + ":" + minutesString;
108 }
109
110 static class StringMeeting {
111 public String start;
112 public String end;
113
114 public StringMeeting(String start, String end) {
115 this.start = start;
116 this.end = end;
117 }
118 }
119
120 static class Meeting {
121 public int start;
122 public int end;
123
124 public Meeting(int start, int end) {
125 this.start = start;
126 this.end = end;
127 }
128 }
129 }
130

### Solution 6

```
new Meeting(
timeToMinutes(updatedCalendar.get(i).start),
timeToMinutes(updatedCalendar.get(i).end)));
}
return calendarInMinutes;
}
public static List<Meeting> mergeCalendars(List<Meeting> calendar1, List<Meeting> calendar2) {
List<Meeting> merged = new ArrayList<Meeting>();
int i = 0;
int j = 0;
while (i < calendar1.size() && j < calendar2.size()) {
Meeting meeting1 = calendar1.get(i);
Meeting meeting2 = calendar2.get(j);
if (meeting1.start < meeting2.start) {
merged.add(meeting1);
i++;
} else {
merged.add(meeting2);
j++;
}
}
while (i < calendar1.size()) merged.add(calendar1.get(i++));
while (j < calendar2.size()) merged.add(calendar2.get(j++));
return merged;
}
public static List<Meeting> flattenCalendar(List<Meeting> calendar) {
List<Meeting> flattened = new ArrayList<Meeting>();
flattened.add(calendar.get(0));
for (int i = 1; i < calendar.size(); i++) {
Meeting currentMeeting = calendar.get(i);
Meeting previousMeeting = flattened.get(flattened.size() - 1);
if (previousMeeting.end >= currentMeeting.start) {
Meeting newPreviousMeeting =
new Meeting(previousMeeting.start, Math.max(previousMeeting.end, currentMeeting.end));
flattened.set(flattened.size() - 1, newPreviousMeeting);
} else {
flattened.add(currentMeeting);
}
}
return flattened;
}
public static List<StringMeeting> getMatchingAvailabilities(
List<Meeting> calendar, int meetingDuration) {
g g ) {
List<Meeting> matchingAvailabilities = new ArrayList<Meeting>();
for (int i = 1; i < calendar.size(); i++) {
int start = calendar.get(i - 1).end;
int end = calendar.get(i).start;
int availabilityDuration = end - start;
if (availabilityDuration >= meetingDuration) {
matchingAvailabilities.add(new Meeting(start, end));
}
}
List<StringMeeting> matchingAvailabilitiesInHours = new ArrayList<StringMeeting>();
for (int i = 0; i < matchingAvailabilities.size(); i++) {
matchingAvailabilitiesInHours.add(
new StringMeeting(
minutesToTime(matchingAvailabilities.get(i).start),
minutesToTime(matchingAvailabilities.get(i).end)));
}
return matchingAvailabilitiesInHours;
}
public static int timeToMinutes(String time) {
int delimiterPos = time.indexOf(":");
int hours = Integer.parseInt(time.substring(0, delimiterPos));
int minutes = Integer.parseInt(time.substring(delimiterPos + 1, time.length()));
return hours * 60 + minutes;
}
public static String minutesToTime(int minutes) {
int hours = minutes / 60;
int mins = minutes % 60;
String hoursString = Integer.toString(hours);
String minutesString = mins < 10 ? "0" + Integer.toString(mins) : Integer.toString(mins);
return hoursString + ":" + minutesString;
}

### Solution 7

```
52 while (i < calendar1.size()) merged.add(calendar1.get(i++));
53 while (j < calendar2.size()) merged.add(calendar2.get(j++));
54 return merged;
55 }
56
57 public static List<Meeting> flattenCalendar(List<Meeting> calendar) {
58 List<Meeting> flattened = new ArrayList<Meeting>();
59 flattened.add(calendar.get(0));
60 for (int i = 1; i < calendar.size(); i++) {
61 Meeting currentMeeting = calendar.get(i);
62 Meeting previousMeeting = flattened.get(flattened.size() - 1);
63 if (previousMeeting.end >= currentMeeting.start) {
64 Meeting newPreviousMeeting =
65 new Meeting(previousMeeting.start, Math.max(previousMeeting.end, currentMeeting.end));
66 flattened.set(flattened.size() - 1, newPreviousMeeting);
67 } else {
68 flattened.add(currentMeeting);
69 }
70 }
71 return flattened;
72 }
73
74 public static List<StringMeeting> getMatchingAvailabilities(
75 List<Meeting> calendar, int meetingDuration) {
76 List<Meeting> matchingAvailabilities = new ArrayList<Meeting>();
77 for (int i = 1; i < calendar.size(); i++) {
78 int start = calendar.get(i - 1).end;
79 int end = calendar.get(i).start;
80 int availabilityDuration = end - start;
81 if (availabilityDuration >= meetingDuration) {
82 matchingAvailabilities.add(new Meeting(start, end));
83 }
84 }
85 List<StringMeeting> matchingAvailabilitiesInHours = new ArrayList<StringMeeting>();
86 for (int i = 0; i < matchingAvailabilities.size(); i++) {
87 matchingAvailabilitiesInHours.add(
88 new StringMeeting(
89 minutesToTime(matchingAvailabilities.get(i).start),
90 minutesToTime(matchingAvailabilities.get(i).end)));
91 }
92 return matchingAvailabilitiesInHours;
93 }
94
95 public static int timeToMinutes(String time) {
96 int delimiterPos = time.indexOf(":");
97 int hours = Integer parseInt(time substring(0 delimiterPos));
97 int hours = Integer.parseInt(time.substring(0, delimiterPos));
98 int minutes = Integer.parseInt(time.substring(delimiterPos + 1, time.length()));
99 return hours * 60 + minutes;
100 }
101
102 public static String minutesToTime(int minutes) {
103 int hours = minutes / 60;
104 int mins = minutes % 60;
105 String hoursString = Integer.toString(hours);

### Solution 8

```java
import java.util.*;
class Program {
// O(c1 + c2) time | O(c1 + c2) space - where c1 and c2 are the respective numbers of meetings
// in calendar1 and calendar2
public static List<StringMeeting> calendarMatching(
List<StringMeeting> calendar1,
StringMeeting dailyBounds1,
List<StringMeeting> calendar2,
StringMeeting dailyBounds2,
int meetingDuration) {
List<Meeting> updatedCalendar1 = updateCalendar(calendar1, dailyBounds1);
List<Meeting> updatedCalendar2 = updateCalendar(calendar2, dailyBounds2);
List<Meeting> mergedCalendar = mergeCalendars(updatedCalendar1, updatedCalendar2);
List<Meeting> flattenedCalendar = flattenCalendar(mergedCalendar);
return getMatchingAvailabilities(flattenedCalendar, meetingDuration);
}
public static List<Meeting> updateCalendar(
List<StringMeeting> calendar, StringMeeting dailyBounds) {
List<StringMeeting> updatedCalendar = new ArrayList<StringMeeting>();
updatedCalendar.add(new StringMeeting("0:00", dailyBounds.start));
updatedCalendar.addAll(calendar);
updatedCalendar.add(new StringMeeting(dailyBounds.end, "23:59"));
List<Meeting> calendarInMinutes = new ArrayList<Meeting>();
for (int i = 0; i < updatedCalendar.size(); i++) {
calendarInMinutes.add(
new Meeting(
timeToMinutes(updatedCalendar.get(i).start),
timeToMinutes(updatedCalendar.get(i).end)));
}
return calendarInMinutes;
}
public static List<Meeting> mergeCalendars(List<Meeting> calendar1, List<Meeting> calendar2) {
List<Meeting> merged = new ArrayList<Meeting>();
int i = 0;

```
---

## Test Cases

```
Yay, our code passed all the test cases!

Test Case 1 passed!
Our Code's Output
[["11:30", "12:00"], ["15:00", "16:00"], ["18:00", "18:30"]]
Input(s)
{
  "calendar1": [["9:00", "10:30"], ["12:00", "13:00"], ["16:00", "18:00"]],
  "calendar2": [
    ["10:00", "11:30"],
    ["12:30", "14:30"],
    ["14:30", "15:00"],
    ["16:00", "17:00"]
  ],
  "dailyBounds1": ["9:00", "20:00"],
  "dailyBounds2": ["10:00", "18:30"],
  "meetingDuration": 30
}
Test Case 2 passed!
Our Code's Output
[["11:30", "12:00"], ["15:00", "16:00"], ["18:00", "18:30"]]
Input(s)
{
  "calendar1": [["9:00", "10:30"], ["12:00", "13:00"], ["16:00", "18:00"]],
  "calendar2": [
    ["10:00", "11:30"],
    ["12:30", "14:30"],
    ["14:30", "15:00"],
    ["16:00", "17:00"]
  ],
  "dailyBounds1": ["9:00", "20:00"],
  "dailyBounds2": ["10:00", "18:30"],
  "meetingDuration": 30
}
Test Case 3 passed!
Our Code's Output
[["15:00", "16:00"]]
Input(s)
{
  "calendar1": [["9:00", "10:30"], ["12:00", "13:00"], ["16:00", "18:00"]],
  "calendar2": [
    ["10:00", "11:30"],
    ["12:30", "14:30"],
    ["14:30", "15:00"],
    ["16:00", "17:00"]
  ],
  "dailyBounds1": ["9:00", "20:00"],
  "dailyBounds2": ["10:00", "18:30"],
  "meetingDuration": 45
}
Test Case 4 passed!
Our Code's Output
[["8:00", "9:00"], ["15:00", "16:00"]]
Input(s)
{
  "calendar1": [["9:00", "10:30"], ["12:00", "13:00"], ["16:00", "18:00"]],
  "calendar2": [
    ["10:00", "11:30"],
    ["12:30", "14:30"],
    ["14:30", "15:00"],
    ["16:00", "17:00"]
  ],
  "dailyBounds1": ["8:00", "20:00"],
  "dailyBounds2": ["7:00", "18:30"],
  "meetingDuration": 45
}
Test Case 5 passed!
Our Code's Output
[]
Input(s)
{
  "calendar1": [
    ["8:00", "10:30"],
    ["11:30", "13:00"],
    ["14:00", "16:00"],
    ["16:00", "18:00"]
  ],
  "calendar2": [
    ["10:00", "11:30"],
    ["12:30", "14:30"],
    ["14:30", "15:00"],
    ["16:00", "17:00"]
  ],
  "dailyBounds1": ["8:00", "18:00"],
  "dailyBounds2": ["7:00", "18:30"],
  "meetingDuration": 15
}
Test Case 6 passed!
Our Code's Output
[["9:30", "10:00"], ["11:15", "11:30"], ["13:30", "14:15"], ["18:00", "18:30"]]
Input(s)
{
  "calendar1": [
    ["10:00", "10:30"],
    ["10:45", "11:15"],
    ["11:30", "13:00"],
    ["14:15", "16:00"],
    ["16:00", "18:00"]
  ],
  "calendar2": [
    ["10:00", "11:00"],
    ["12:30", "13:30"],
    ["14:30", "15:00"],
    ["16:00", "17:00"]
  ],
  "dailyBounds1": ["9:30", "20:00"],
  "dailyBounds2": ["9:00", "18:30"],
  "meetingDuration": 15
}
Test Case 7 passed!
Our Code's Output
[]
Input(s)
{
  "calendar1": [
    ["10:00", "10:30"],
    ["10:45", "11:15"],
    ["11:30", "13:00"],
    ["14:15", "16:00"],
    ["16:00", "18:00"]
  ],
  "calendar2": [["10:00", "11:00"], ["10:30", "20:30"]],
  "dailyBounds1": ["9:30", "20:00"],
  "dailyBounds2": ["9:00", "22:30"],
  "meetingDuration": 60
}
Test Case 8 passed!
Our Code's Output
[["18:00", "20:00"]]
Input(s)
{
  "calendar1": [
    ["10:00", "10:30"],
    ["10:45", "11:15"],
    ["11:30", "13:00"],
    ["14:15", "16:00"],
    ["16:00", "18:00"]
  ],
  "calendar2": [["10:00", "11:00"], ["10:30", "16:30"]],
  "dailyBounds1": ["9:30", "20:00"],
  "dailyBounds2": ["9:00", "22:30"],
  "meetingDuration": 60
}
Test Case 9 passed!
Our Code's Output
[["9:30", "16:30"]]
Input(s)
{
  "calendar1": [],
  "calendar2": [],
  "dailyBounds1": ["9:30", "20:00"],
  "dailyBounds2": ["9:00", "16:30"],
  "meetingDuration": 60
}
Test Case 10 passed!
Our Code's Output
[["9:30", "16:30"]]
Input(s)
{
  "calendar1": [],
  "calendar2": [],
  "dailyBounds1": ["9:00", "16:30"],
  "dailyBounds2": ["9:30", "20:00"],
  "meetingDuration": 60
}
Test Case 11 passed!
Our Code's Output
[["9:30", "16:30"]]
Input(s)
{
  "calendar1": [],
  "calendar2": [],
  "dailyBounds1": ["9:30", "16:30"],
  "dailyBounds2": ["9:30", "16:30"],
  "meetingDuration": 60
}
Test Case 12 passed!
Our Code's Output
[["8:30", "9:00"], ["10:30", "11:15"], ["19:00", "20:00"]]
Input(s)
{
  "calendar1": [
    ["7:00", "7:45"],
    ["8:15", "8:30"],
    ["9:00", "10:30"],
    ["12:00", "14:00"],
    ["14:00", "15:00"],
    ["15:15", "15:30"],
    ["16:30", "18:30"],
    ["20:00", "21:00"]
  ],
  "calendar2": [
    ["9:00", "10:00"],
    ["11:15", "11:30"],
    ["11:45", "17:00"],
    ["17:30", "19:00"],
    ["20:00", "22:15"]
  ],
  "dailyBounds1": ["6:30", "22:00"],
  "dailyBounds2": ["8:00", "22:30"],
  "meetingDuration": 30
}

```
1
2
​
3
import java.util.*;
4
​
5
class Program {
6
  // O(c1 + c2) time | O(c1 + c2) space - where c1 and c2 are the respective numbers of meetings
7
  // in calendar1 and calendar2
8
  public static List<StringMeeting> calendarMatching(
9
      List<StringMeeting> calendar1,
10
      StringMeeting dailyBounds1,
11
      List<StringMeeting> calendar2,
12
      StringMeeting dailyBounds2,
13
      int meetingDuration) {
14
    List<Meeting> updatedCalendar1 = updateCalendar(calendar1, dailyBounds1);
15
    List<Meeting> updatedCalendar2 = updateCalendar(calendar2, dailyBounds2);
16
    List<Meeting> mergedCalendar = mergeCalendars(updatedCalendar1, updatedCalendar2);
17
    List<Meeting> flattenedCalendar = flattenCalendar(mergedCalendar);
18
    return getMatchingAvailabilities(flattenedCalendar, meetingDuration);
19
  }
20
​
21
  public static List<Meeting> updateCalendar(
22
      List<StringMeeting> calendar, StringMeeting dailyBounds) {
23
    List<StringMeeting> updatedCalendar = new ArrayList<StringMeeting>();
24
    updatedCalendar.add(new StringMeeting("0:00", dailyBounds.start));
25
    updatedCalendar.addAll(calendar);
26
    updatedCalendar.add(new StringMeeting(dailyBounds.end, "23:59"));
27
    List<Meeting> calendarInMinutes = new ArrayList<Meeting>();
28
    for (int i = 0; i < updatedCalendar.size(); i++) {
29
      calendarInMinutes.add(
30
          new Meeting(
31
              timeToMinutes(updatedCalendar.get(i).start),
32
              timeToMinutes(updatedCalendar.get(i).end)));
33
    }
34
    return calendarInMinutes;
35
  }
36
​
37
  public static List<Meeting> mergeCalendars(List<Meeting> calendar1, List<Meeting> calendar2) {
38
    List<Meeting> merged = new ArrayList<Meeting>();
39
    int i = 0;
40
    int j = 0;
41
    while (i < calendar1.size() && j < calendar2.size()) {
42
      Meeting meeting1 = calendar1.get(i);
43
      Meeting meeting2 = calendar2.get(j);
44
      if (meeting1.start < meeting2.start) {
45
        merged.add(meeting1);
46
        i++;
47
      } else {
48
        merged.add(meeting2);
49
        j++;
50
      }
51
    }
52
    while (i < calendar1.size()) merged.add(calendar1.get(i++));
53
    while (j < calendar2.size()) merged.add(calendar2.get(j++));
54
    return merged;
55
  }
56
​
57
  public static List<Meeting> flattenCalendar(List<Meeting> calendar) {

```
Test Case 1
{
  "calendar1": [["9:00", "10:30"], ["12:00", "13:00"], ["16:00", "18:00"]],
  "dailyBounds1": ["9:00", "20:00"],
  "calendar2": [
    ["10:00", "11:30"],
    ["12:30", "14:30"],
    ["14:30", "15:00"],
    ["16:00", "17:00"]
  ],
  "dailyBounds2": ["10:00", "18:30"],
  "meetingDuration": 30
}
Test Case 2
{
  "calendar1": [["9:00", "10:30"], ["12:00", "13:00"], ["16:00", "18:00"]],
  "dailyBounds1": ["9:00", "20:00"],
  "calendar2": [
    ["10:00", "11:30"],
    ["12:30", "14:30"],
    ["14:30", "15:00"],
    ["16:00", "17:00"]
  ],
  "dailyBounds2": ["10:00", "18:30"],
  "meetingDuration": 30
}
Test Case 3
{
  "calendar1": [["9:00", "10:30"], ["12:00", "13:00"], ["16:00", "18:00"]],
  "dailyBounds1": ["9:00", "20:00"],
  "calendar2": [
    ["10:00", "11:30"],
    ["12:30", "14:30"],
    ["14:30", "15:00"],
    ["16:00", "17:00"]
  ],
  "dailyBounds2": ["10:00", "18:30"],
  "meetingDuration": 45
}
Test Case 4
{
  "calendar1": [["9:00", "10:30"], ["12:00", "13:00"], ["16:00", "18:00"]],
  "dailyBounds1": ["8:00", "20:00"],
  "calendar2": [
    ["10:00", "11:30"],
    ["12:30", "14:30"],
    ["14:30", "15:00"],
    ["16:00", "17:00"]
  ],
  "dailyBounds2": ["7:00", "18:30"],
  "meetingDuration": 45
}
Test Case 5
{
  "calendar1": [
    ["8:00", "10:30"],
    ["11:30", "13:00"],
    ["14:00", "16:00"],
    ["16:00", "18:00"]
  ],
  "dailyBounds1": ["8:00", "18:00"],
  "calendar2": [
    ["10:00", "11:30"],
    ["12:30", "14:30"],
    ["14:30", "15:00"],
    ["16:00", "17:00"]
  ],
  "dailyBounds2": ["7:00", "18:30"],
  "meetingDuration": 15
}
Test Case 6
{
  "calendar1": [
    ["10:00", "10:30"],
    ["10:45", "11:15"],
    ["11:30", "13:00"],
    ["14:15", "16:00"],
    ["16:00", "18:00"]
  ],
  "dailyBounds1": ["9:30", "20:00"],
  "calendar2": [
    ["10:00", "11:00"],
    ["12:30", "13:30"],
    ["14:30", "15:00"],
    ["16:00", "17:00"]
  ],
  "dailyBounds2": ["9:00", "18:30"],
  "meetingDuration": 15
}
Test Case 7
{
  "calendar1": [
    ["10:00", "10:30"],
    ["10:45", "11:15"],
    ["11:30", "13:00"],
    ["14:15", "16:00"],
    ["16:00", "18:00"]
  ],
  "dailyBounds1": ["9:30", "20:00"],
  "calendar2": [["10:00", "11:00"], ["10:30", "20:30"]],
  "dailyBounds2": ["9:00", "22:30"],
  "meetingDuration": 60
}
Test Case 8
{
  "calendar1": [
    ["10:00", "10:30"],
    ["10:45", "11:15"],
    ["11:30", "13:00"],
    ["14:15", "16:00"],
    ["16:00", "18:00"]
  ],
  "dailyBounds1": ["9:30", "20:00"],
  "calendar2": [["10:00", "11:00"], ["10:30", "16:30"]],
  "dailyBounds2": ["9:00", "22:30"],
  "meetingDuration": 60
}
Test Case 9
{
  "calendar1": [],
  "dailyBounds1": ["9:30", "20:00"],
  "calendar2": [],
  "dailyBounds2": ["9:00", "16:30"],
  "meetingDuration": 60
}
Test Case 10
{
  "calendar1": [],
  "dailyBounds1": ["9:00", "16:30"],
  "calendar2": [],
  "dailyBounds2": [
... (test file truncated for display)
```
