package petopia_todo_ult.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import petopia_todo_ult.models.*;
import petopia_todo_ult.services.*;


import java.util.Date;

@Configuration
@Slf4j
public class InitialData {
    @Autowired
    AnimalService animalService;

    @Autowired
    HistorialService historialService;

    @Autowired
    ClinicaService clinicaService;

    @Autowired
    VacunasService vacunasService;

    @Autowired
    SeguimientoService seguimientoService;

    @Autowired
    EmpleadoService empleadoService;

    @PostConstruct
    public void initAnimales() {

        //// ANIMALES ////
        Animal animal1 = Animal.builder().name("Iko").animal_type("Perro").chip(123456L).sex("Macho").color("Blanco").state(State.RECOGIDO).size("Grande").date_of_birth(new Date(2021, 6, 21)).description("Perro cariñoso y jugueton").build();
        Animal animal2 = Animal.builder().name("Max").animal_type("Perro").chip(456789L).sex("Macho").color("Marron").state(State.SIN_HOGAR).size("Mediano").date_of_birth(new Date(2020, 9, 12)).description("Muy dormilon").build();
        Animal animal3 = Animal.builder().name("Luna").animal_type("Gato").chip(987654L).sex("Hembra").color("Negro").state(State.ADOPCION).size("Mediano").date_of_birth(new Date(2019, 3, 9)).description("Le encanta comer").build();
        Animal animal4 = Animal.builder().name("Simba").animal_type("Gato").chip(987123L).sex("Macho").color("Naranja").state(State.RECOGIDO).size("Pequeño").date_of_birth(new Date(2022, 10, 30)).description("Es muy observador y le gusta trepar").build();
        Animal animal5 = Animal.builder().name("Coco").animal_type("Perro").chip(678901L).sex("Hembra").color("Marron").state(State.SIN_HOGAR).size("Pequeño").date_of_birth(new Date(2021, 7, 3)).description("Le gusta jugar").build();
        Animal animal6 = Animal.builder().name("Lola").animal_type("Gato").chip(901234L).sex("Hembra").color("Blanca").state(State.ADOPCION).size("Pequeño").date_of_birth(new Date(2023, 4, 14)).description("Le tiene un poco de miedo a la gente").build();
        Animal animal7 = Animal.builder().name("Calcetines").animal_type("Gato").chip(546913L).sex("Macho").color("Negro").state(State.SIN_HOGAR).size("Grande").date_of_birth(new Date(2020, 1, 9)).description("Le gusta robar calcetines y jugar").build();
        Animal animal8 = Animal.builder().name("Roxy").animal_type("Perro").chip(627938L).sex("Hembra").color("Blanco").state(State.ACOGIDO).size("Mediano").date_of_birth(new Date(2021, 11, 17)).description("Le gusta robar calcetines y jugar").build();
        Animal animal9 = Animal.builder().name("Cooper").animal_type("Gato").chip(214967L).sex("Macho").color("Blanco").state(State.ACOGIDO).size("Mediano").date_of_birth(new Date(2019, 3, 9)).description("Le apasiona cazar").build();
        Animal animal10 = Animal.builder().name("Buddy").animal_type("Gato").chip(549460L).sex("Macho").color("Naranja").state(State.SIN_HOGAR).size("Grande").date_of_birth(new Date(2020, 5, 10)).description("Le gusta mucho jugar").build();

        animalService.createAnimal(animal1);
        animalService.createAnimal(animal2);
        animalService.createAnimal(animal3);
        animalService.createAnimal(animal4);
        animalService.createAnimal(animal5);
        animalService.createAnimal(animal6);
        animalService.createAnimal(animal7);
        animalService.createAnimal(animal8);
        animalService.createAnimal(animal9);
        animalService.createAnimal(animal10);


        //// HISTORIAL ////
        Historial h1 = Historial.builder().patologias("Gripe canina").medicamentos("Antibióticos").veterinario("Dr. López").fecha_consulta(new Date(2022, 10, 15)).build();
        Historial h2 = Historial.builder().patologias("Desparasitación").medicamentos("Antibióticos").veterinario("Dr. García").fecha_consulta(new Date(2022, 1, 12)).build();
        Historial h3 = Historial.builder().patologias("Infección de oído").medicamentos("Gotas antibióticas").veterinario("Dr. Rodríguez").fecha_consulta(new Date(2022, 4, 10)).build();
        Historial h4 = Historial.builder().patologias("Fractura de pata").medicamentos("Férula y analgésicos").veterinario("Dr. Gómez").fecha_consulta(new Date(2022, 2, 20)).build();
        Historial h5 = Historial.builder().patologias("Problemas digestivo").medicamentos("Dieta especial y medicamentos").veterinario("Dra. López").fecha_consulta(new Date(2023, 5, 5)).build();
        Historial h6 = Historial.builder().patologias("Vacunación anual").medicamentos("Vacuna polivalente").veterinario("Dr. Martínez").fecha_consulta(new Date(2023, 6, 1)).build();
        Historial h7 = Historial.builder().patologias("Extracción de diente").medicamentos("Analgésicos y antibióticos").veterinario("Dra. Fernández").fecha_consulta(new Date(2023, 4, 24)).build();
        Historial h8 = Historial.builder().patologias("Desparasitación").medicamentos("Antiparasitario oral").veterinario("Dr. Sánchez").fecha_consulta(new Date(2023, 2, 17)).build();

        historialService.createHistorial(h1);
        historialService.createHistorial(h2);
        historialService.createHistorial(h3);
        historialService.createHistorial(h4);
        historialService.createHistorial(h5);
        historialService.createHistorial(h6);
        historialService.createHistorial(h7);
        historialService.createHistorial(h8);


        //// CLINICA ////
        Clinica c1 = Clinica.builder().cif(6583473L).num_contacto("987654321").nombre("Clínica Veterinaria Pelicano").direccion("Calle Goya 47").ciudad("Zaragoza").build();
        Clinica c2 = Clinica.builder().cif(967832L).num_contacto("123456789").nombre("Centro Veterinario Huellas").direccion("Avenida del Aguacate 24").ciudad("Madrid").build();
        Clinica c3 = Clinica.builder().cif(5489673L).num_contacto("919919919").nombre("Clínica Veterinaria Amigos Peludos").direccion("Calle Fernan Gonzalez 75").ciudad("Madrid").build();
        Clinica c4 = Clinica.builder().cif(1920390L).num_contacto("654321987").nombre("Clínica Veterinaria Patitas Felices").direccion("Avenida Mascotas 45").ciudad("Barcelona").build();
        Clinica c5 = Clinica.builder().cif(5860352L).num_contacto("321654987").nombre("Clínica Veterinaria Cuidado Animal").direccion("Calle Animales 81").ciudad("Valencia").build();

        clinicaService.createClinica(c1);
        clinicaService.createClinica(c2);
        clinicaService.createClinica(c3);
        clinicaService.createClinica(c4);
        clinicaService.createClinica(c5);


        //// VACUNAS ////
        Vacunas v1 = Vacunas.builder().nombre("Vacuna contra la rabia").descripcion("Protege contra la rabia en perros y gatos").fecha_caducidad((new Date(2025, 6, 1))).marca("VacunaCorp").lote("123ABC").build();
        Vacunas v2 = Vacunas.builder().nombre("Vacuna felina triple").descripcion("Protege contra varias enfermedades en gatos").fecha_caducidad((new Date(2026, 3, 30))).marca("PetVax").lote("456DEF").build();
        Vacunas v3 = Vacunas.builder().nombre("Vacuna contra la leptospirosis").descripcion("Protege contra la leptospirosis en perros").fecha_caducidad((new Date(2024, 5, 15))).marca("DogGuard").lote("789XYZ").build();
        Vacunas v4 = Vacunas.builder().nombre("Vacuna contra la panleucopenia").descripcion("Protege contra la panleucopenia en gatos").fecha_caducidad((new Date(2024, 12, 21))).marca("FelinaShield").lote("DEF456").build();
        Vacunas v5 = Vacunas.builder().nombre("Vacuna contra la parvovirosis").descripcion("Protege contra la parvovirosis en perros").fecha_caducidad((new Date(2025, 8, 10))).marca("FelinaShield").lote("GHI789").build();
        Vacunas v6 = Vacunas.builder().nombre("Vacuna contra la leptospirosis").descripcion("Protege contra la leptospirosis en perros").fecha_caducidad((new Date(2024, 5, 15))).marca("DogGuard").lote("789XYZ").build();
        Vacunas v7 = Vacunas.builder().nombre("Vacuna contra la rabia").descripcion("Protege contra la rabia en perros y gatos").fecha_caducidad((new Date(2025, 6, 1))).marca("VacunaCorp").lote("123ABC").build();

        vacunasService.createVacunas(v1);
        vacunasService.createVacunas(v2);
        vacunasService.createVacunas(v3);
        vacunasService.createVacunas(v4);
        vacunasService.createVacunas(v5);
        vacunasService.createVacunas(v6);
        vacunasService.createVacunas(v7);

        //// EMPLEADOS ////
        Empleado em1 = Empleado.builder().dni("11111111A").nombre("Pedro").apellidos("Martínez").direccion("Calle Goya, 345").tipo_empleado(TipoEmpleado.ASALARIADO).clinica(c1).build();
        Empleado em2 = Empleado.builder().dni("22222222B").nombre("María").apellidos("López").direccion("Calle Hortaleza, 7890").tipo_empleado(TipoEmpleado.VOLUNTARIO).clinica(c1).build();
        Empleado em3 = Empleado.builder().dni("33333333C").nombre("Nieves").apellidos("González").direccion("Paseo de la Castellana, 101").tipo_empleado(TipoEmpleado.ASALARIADO).clinica(c2).build();
        Empleado em4 = Empleado.builder().dni("44444444D").nombre("Carlos").apellidos("Hernández").direccion("Calle Alberto Aguilera, 3456").tipo_empleado(TipoEmpleado.VOLUNTARIO).clinica(c2).build();
        Empleado em5 = Empleado.builder().dni("55555555E").nombre("Laura").apellidos("Ramírez").direccion("Paseo de la Florida, 9012").tipo_empleado(TipoEmpleado.ASALARIADO).clinica(c3).build();
        Empleado em6 = Empleado.builder().dni("66666666F").nombre("Antonio").apellidos("Torres").direccion("Avenida Menéndez Pelayo, 1234").tipo_empleado(TipoEmpleado.VOLUNTARIO).clinica(c3).build();
        Empleado em7 = Empleado.builder().dni("77777777G").nombre("Jorge").apellidos("García").direccion("Calle Fuencarral, 234").tipo_empleado(TipoEmpleado.ASALARIADO).clinica(c4).build();
        Empleado em8 = Empleado.builder().dni("88888888H").nombre("Cristian").apellidos("Sánchez").direccion("Calle Serrano, 890").tipo_empleado(TipoEmpleado.VOLUNTARIO).clinica(c4).build();
        Empleado em9 = Empleado.builder().dni("99999999I").nombre("Jesus").apellidos("Ortega").direccion("Paseo de la Habana, 999").tipo_empleado(TipoEmpleado.ASALARIADO).clinica(c5).build();
        Empleado em10 = Empleado.builder().dni("00000000J").nombre("Joana").apellidos("Herrera").direccion("Calle Arturo Soria, 9012").tipo_empleado(TipoEmpleado.VOLUNTARIO).clinica(c5).build();

        empleadoService.createEmpleado(em1);
        empleadoService.createEmpleado(em2);
        empleadoService.createEmpleado(em3);
        empleadoService.createEmpleado(em4);
        empleadoService.createEmpleado(em5);
        empleadoService.createEmpleado(em6);
        empleadoService.createEmpleado(em7);
        empleadoService.createEmpleado(em8);
        empleadoService.createEmpleado(em9);
        empleadoService.createEmpleado(em10);


        //// SEGUIMIENTOS ////
        Seguimiento s1 = Seguimiento.builder().estado("Muy bueno").fecha((new Date(2022, 11, 29))).animal(animal3).empleado(em1).build();
        Seguimiento s2 = Seguimiento.builder().estado("Bueno, aumento su peso").fecha((new Date(2023, 1, 8))).animal(animal6).empleado(em3).build();
        Seguimiento s3 = Seguimiento.builder().estado("Muy bueno, se ve feliz").fecha((new Date(2022, 12, 15))).animal(animal8).empleado(em6).build();
        Seguimiento s4 = Seguimiento.builder().estado("Bueno pero sigue con miedo a las personas").fecha((new Date(2023, 2, 3))).animal(animal9).empleado(em8).build();
        Seguimiento s5 = Seguimiento.builder().estado("Muy bueno, le tiene cariño a la familia").fecha((new Date(2023, 3, 17))).animal(animal6).empleado(em9).build();

        seguimientoService.createSeguimiento(s1);
        seguimientoService.createSeguimiento(s2);
        seguimientoService.createSeguimiento(s3);
        seguimientoService.createSeguimiento(s4);
        seguimientoService.createSeguimiento(s5);
    }
}
