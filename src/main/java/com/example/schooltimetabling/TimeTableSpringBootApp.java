/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.schooltimetabling;

import java.time.DayOfWeek;
import java.time.LocalTime;

import com.example.schooltimetabling.domain.Lesson;
import com.example.schooltimetabling.domain.Room;
import com.example.schooltimetabling.domain.Timeslot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

import com.example.schooltimetabling.persistence.LessonRepository;
import com.example.schooltimetabling.persistence.RoomRepository;
import com.example.schooltimetabling.persistence.TimeslotRepository;

@SpringBootApplication
public class TimeTableSpringBootApp {

    public static void main(String[] args) {
        SpringApplication.run(TimeTableSpringBootApp.class, args);
    }

    @Value("${timeTable.demoData:SMALL}")
    private DemoData demoData;

    @Bean
    public CommandLineRunner demoData(
            TimeslotRepository timeslotRepository,
            RoomRepository roomRepository,
            LessonRepository lessonRepository) {
        return (args) -> {
            if (demoData == DemoData.NONE) {
                return;
            }

            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(8, 30), LocalTime.of(10, 20)));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(10, 30), LocalTime.of(12, 20)));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(13, 30), LocalTime.of(15, 20)));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(15, 30), LocalTime.of(17, 20)));
            timeslotRepository.save(new Timeslot(DayOfWeek.TUESDAY, LocalTime.of(8, 30), LocalTime.of(10, 20)));
            timeslotRepository.save(new Timeslot(DayOfWeek.TUESDAY, LocalTime.of(10, 30), LocalTime.of(12, 20)));
            timeslotRepository.save(new Timeslot(DayOfWeek.TUESDAY, LocalTime.of(13, 30), LocalTime.of(15, 20)));
            timeslotRepository.save(new Timeslot(DayOfWeek.TUESDAY, LocalTime.of(15, 30), LocalTime.of(17, 20)));
            timeslotRepository.save(new Timeslot(DayOfWeek.WEDNESDAY, LocalTime.of(8, 30), LocalTime.of(10, 20)));
            timeslotRepository.save(new Timeslot(DayOfWeek.WEDNESDAY, LocalTime.of(10, 30), LocalTime.of(12, 20)));
            timeslotRepository.save(new Timeslot(DayOfWeek.WEDNESDAY, LocalTime.of(13, 30), LocalTime.of(15, 20)));
            timeslotRepository.save(new Timeslot(DayOfWeek.WEDNESDAY, LocalTime.of(15, 30), LocalTime.of(17, 20)));
            timeslotRepository.save(new Timeslot(DayOfWeek.THURSDAY, LocalTime.of(8, 30), LocalTime.of(10, 20)));
            timeslotRepository.save(new Timeslot(DayOfWeek.THURSDAY, LocalTime.of(10, 30), LocalTime.of(12, 20)));
            timeslotRepository.save(new Timeslot(DayOfWeek.THURSDAY, LocalTime.of(13, 30), LocalTime.of(15, 20)));
            timeslotRepository.save(new Timeslot(DayOfWeek.THURSDAY, LocalTime.of(15, 30), LocalTime.of(17, 20)));
            timeslotRepository.save(new Timeslot(DayOfWeek.FRIDAY, LocalTime.of(8, 30), LocalTime.of(10, 20)));
            timeslotRepository.save(new Timeslot(DayOfWeek.FRIDAY, LocalTime.of(10, 30), LocalTime.of(12, 20)));
            timeslotRepository.save(new Timeslot(DayOfWeek.FRIDAY, LocalTime.of(13, 30), LocalTime.of(15, 20)));
            timeslotRepository.save(new Timeslot(DayOfWeek.FRIDAY, LocalTime.of(15, 30), LocalTime.of(17, 20)));
            if (demoData == DemoData.LARGE) {
                timeslotRepository.save(new Timeslot(DayOfWeek.SATURDAY, LocalTime.of(8, 30), LocalTime.of(10, 20)));
                timeslotRepository.save(new Timeslot(DayOfWeek.SATURDAY, LocalTime.of(10, 30), LocalTime.of(12, 20)));
                timeslotRepository.save(new Timeslot(DayOfWeek.SATURDAY, LocalTime.of(13, 30), LocalTime.of(15, 20)));
                timeslotRepository.save(new Timeslot(DayOfWeek.SATURDAY, LocalTime.of(15, 30), LocalTime.of(17, 20)));
            }

            roomRepository.save(new Room("A1"));
            roomRepository.save(new Room("A2"));
            roomRepository.save(new Room("A3"));
            /*if (demoData == DemoData.LARGE) {
                roomRepository.save(new Room("B1"));
                roomRepository.save(new Room("B2"));
                roomRepository.save(new Room("B3"));
            }*/

            lessonRepository.save(new Lesson("Encadrement", "Lachgar", "2ITE-3"));
            lessonRepository.save(new Lesson("Encadrement", "Lachgar", "2ITE-3"));
            lessonRepository.save(new Lesson("DevOps", "Assad", "2ITE-3"));
            lessonRepository.save(new Lesson("DevOps", "Assad", "2ITE-3"));
            lessonRepository.save(new Lesson("Programmation web avancée", "Baidada", "2ITE-3"));
            lessonRepository.save(new Lesson("Programmation web avancée", "Baidada", "2ITE-3"));
            lessonRepository.save(new Lesson("Fouille et visualisation des Big Data", "Kaloubi", "2ITE-3"));
            lessonRepository.save(new Lesson("Fouille et visualisation des Big Data", "Kaloubi", "2ITE-3"));
            lessonRepository.save(new Lesson("Architecture et Infrastructure Big Data", "Kaloubi", "2ITE-3"));
            lessonRepository.save(new Lesson("Architecture et Infrastructure Big Data", "Kaloubi", "2ITE-3"));
            lessonRepository.save(new Lesson("Sécurité des Big Data et du Cloud", "Boujnouni", "2ITE-3"));
            lessonRepository.save(new Lesson("Sécurité des Big Data et du Cloud", "Boujnouni", "2ITE-3"));
            lessonRepository.save(new Lesson("Assurance qualité logicielle", "Hannani", "2ITE-3"));
            lessonRepository.save(new Lesson("Assurance qualité logicielle", "Hannani", "2ITE-3"));
            lessonRepository.save(new Lesson("Méthodologie de la recherche scientifique", "Hakik", "2ITE-3"));
            lessonRepository.save(new Lesson("Methodologie de la recherche d'emploi ", "Jada", "2ITE-3"));


            lessonRepository.save(new Lesson("BI", "Hannin", "2ITE-2"));
            lessonRepository.save(new Lesson("BI", "Hannin", "2ITE-2"));
            lessonRepository.save(new Lesson("Statistique & AI", "Boujnouni", "2ITE-2"));
            lessonRepository.save(new Lesson("Statistique & AI", "Boujnouni", "2ITE-2"));
            lessonRepository.save(new Lesson("Statistique & AI", "Boujnouni", "2ITE-2"));

            lessonRepository.save(new Lesson("Java EE", "Lachgar", "2ITE-2"));
            lessonRepository.save(new Lesson("Java EE", "Lachgar", "2ITE-2"));
            lessonRepository.save(new Lesson("Java EE", "Lachgar", "2ITE-2"));
            lessonRepository.save(new Lesson("Dev mobile", "Lachgar", "2ITE-2"));
            lessonRepository.save(new Lesson("Dev mobile", "Lachgar", "2ITE-2"));
            lessonRepository.save(new Lesson("Dev mobile", "Lachgar", "2ITE-2"));
            lessonRepository.save(new Lesson("BD avancee", "Saadi", "2ITE-2"));
            lessonRepository.save(new Lesson("Sockets", "Assad", "2ITE-2"));
            lessonRepository.save(new Lesson("Sockets", "Assad", "2ITE-2"));
            lessonRepository.save(new Lesson("Gestion de projet", "Mami", "2ITE-2"));
            lessonRepository.save(new Lesson("Gestion de projet", "Mami", "2ITE-2"));
            lessonRepository.save(new Lesson("Marketing", "Reda", "2ITE-2"));
            lessonRepository.save(new Lesson("Fr", "Oussama", "2ITE-2"));
            lessonRepository.save(new Lesson("Ang", "Elhadi", "2ITE-2"));

            lessonRepository.save(new Lesson("Python", "Selmam", "2ITE-1"));
            lessonRepository.save(new Lesson("Python", "Selmam", "2ITE-1"));
            lessonRepository.save(new Lesson("Python", "Selmam", "2ITE-1"));
            lessonRepository.save(new Lesson("Archi", "Baidada", "2ITE-1"));
            lessonRepository.save(new Lesson("Archi", "Baidada", "2ITE-1"));
            lessonRepository.save(new Lesson("UML", "Baidada", "2ITE-1"));
            lessonRepository.save(new Lesson("UML", "Baidada", "2ITE-1"));
            lessonRepository.save(new Lesson("Linux", "Assad", "2ITE-1"));
            lessonRepository.save(new Lesson("Linux", "Assad", "2ITE-1"));

            lessonRepository.save(new Lesson("Theorie des graphes & SQL", "Hannin", "2ITE-1"));
            lessonRepository.save(new Lesson("Theorie des graphes & SQL", "Hannin", "2ITE-1"));

            lessonRepository.save(new Lesson("TCP IP", "Dahbi", "2ITE-1"));
            lessonRepository.save(new Lesson("TCP IP", "Dahbi", "2ITE-1"));

            lessonRepository.save(new Lesson("LAN WLAN", "Aqqal", "2ITE-1"));
            lessonRepository.save(new Lesson("LAN WLAN", "Aqqal", "2ITE-1"));
            lessonRepository.save(new Lesson("Transmission", "Ouhmane", "2ITE-1"));
            lessonRepository.save(new Lesson("Transmission", "Ouhmane", "2ITE-1"));
            lessonRepository.save(new Lesson("Fr", "Oussama", "2ITE-1"));
            lessonRepository.save(new Lesson("Ang", "Elhadi", "2ITE-1"));

            Lesson lesson = lessonRepository.findAll(Sort.by("id")).iterator().next();
            lesson.setTimeslot(timeslotRepository.findAll(Sort.by("id")).iterator().next());
            lesson.setRoom(roomRepository.findAll(Sort.by("id")).iterator().next());
            lessonRepository.save(lesson);
        };
    }

    public enum DemoData {
        NONE,
        SMALL,
        LARGE
    }

}
