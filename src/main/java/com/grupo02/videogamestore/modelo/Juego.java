/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo02.videogamestore.modelo;

import javafx.scene.image.Image;
import com.grupo02.TDAs.LinkedList;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author DELL
 */
public class Juego {
    private String titulo;
    private String descripcion;
    private String imagen;
    private String captura;
    private LinkedList<String> genero;
    private String desarrollador;
    private LinkedList<Resena> Resenia;

    public Juego(String titulo, String descripcion, String imagen, String captura, LinkedList<String> genero, String desarrollador, LinkedList<Resena> Resenia) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.captura = captura;
        this.genero = genero;
        this.desarrollador = desarrollador;
        this.Resenia = Resenia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCaptura() {
        return captura;
    }

    public void setCaptura(String captura) {
        this.captura = captura;
    }

    public LinkedList<String> getGenero() {
        return genero;
    }

    public void setGenero(LinkedList<String> genero) {
        this.genero = genero;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public LinkedList<Resena> getResenia() {
        return Resenia;
    }

    public void setResenia(LinkedList<Resena> Resenia) {
        this.Resenia = Resenia;
    }

    
    
    
    public static LinkedList<Juego> loadJuegos() {
        LinkedList<Juego> juegos = new LinkedList<>();
        
        LinkedList<String> genero1 = new LinkedList<>();
        genero1.addLast("Acción");genero1.addLast("Aventura");genero1.addLast("Rol");
        
        LinkedList<Resena> reseniaGodofwar = new LinkedList<>();
        reseniaGodofwar.addLast(new Resena("Jose Luis Ortega",4, LocalDate.of(2018, Month.MARCH, 10),"kjdkjd"));
        juegos.addLast(new Juego("God of War", "Kratos ha dejado atrás su venganza contra los dioses del Olimpo y vive ahora como un hombre en los dominios de los dioses y los monstruos nórdico. En este mundo cruel e implacable debe luichar para sobrevivir... y enseñar a su hijo a hacerlo tambien","/imagenesJuegos/godofwar.jpg","/imagenesJuegos/godofwarCap.jpg", genero1,"Santa Monica Studio",reseniaGodofwar));
        
        LinkedList<Resena> reseniaSpiderman = new LinkedList<>();
        reseniaSpiderman.addLast(new Resena("Lionel Messi",5, LocalDate.of(2018, Month.JANUARY, 10),"buen jeugo"));
        juegos.addLast(new Juego("Spiderman","El mundo de Peter Parker choca con el de Spider-Man en una historia original repleta de acción. Encarna a un experimentado Peter Parker y lucha contra el hampa y un elenco de villanos archiconocidos en la Nueva York de Marvel. Balancéate por barrios bulliciosos y derrota a los villanos de forma espectacular.","/imagenesJuegos/spiderman.jpg","/imagenesJuegos/spidermanCap.jpg", genero1, "Insomniac Games", reseniaSpiderman));
        
        LinkedList<Resena> reseniaSpiderman2 = new LinkedList<>();
        reseniaSpiderman2.addLast(new Resena("Lionel Messi",5, LocalDate.of(2022, Month.SEPTEMBER, 18),"Excelente"));
        juegos.addLast(new Juego("Spiderman Miles Morales","En la última aventura del universo de Spider-Man de Marvel, el adolescente Miles Morales intenta ajustarse a su nuevo hogar mientras que sigue los pasos de su mentor, Peter Parker, para convertirse en el nuevo Spider-Man.\n" +"\n" +"Pero cuando un feroz enfrentamiento por el poder amenaza con destruir su hogar, el aspirante a héroe entiende que un gran poder conlleva una gran responsabilidad. Para salvar a la Nueva York de Marvel, Miles debe adoptar el manto de Spider-Man y volverlo propio.","/imagenesJuegos/spiderman2.jpg","/imagenesJuegos/spiderman2Cap.jpg", genero1, "Insomniac Games", reseniaSpiderman2));
        
        LinkedList<Resena> reseniaBatman1 = new LinkedList<>();
        reseniaBatman1.addLast(new Resena("Enner Valencia",3, LocalDate.of(2019, Month.OCTOBER, 12),"Excelente"));
        juegos.addLast(new Juego("Batman Arkham Asylum","Experimenta lo que es ser Batman y enfréntate contra los mayores villanos de Gotham. Explora cada rincón del Asilo de Arkham y deambula libremente en la famosa isla.","/imagenesJuegos/batmanarkhamasylum.jpg","/imagenesJuegos/batmanarkhamasylumCap.jpg", genero1, "Rocsteady Studios", reseniaBatman1));
        
        
        LinkedList<Resena> reseniaBatman2 = new LinkedList<>();
        reseniaBatman2.addLast(new Resena("Enner Valencia",5, LocalDate.of(2020, Month.OCTOBER, 3),"Excelente juego"));
        juegos.addLast(new Juego("Batman Arkham Knight",        "Batman™: Arkham Knight es la épica conclusión de la galardonada trilogía de Arkham, creada por Rocksteady Studios. El título, desarrollado en exclusiva para plataformas de nueva generación, presenta la espectacular versión del batmóvil imaginada por Rocksteady. La incorporación del legendario vehículo, unida al aclamado sistema de juego de la serie Arkham, ofrece a los jugadores una recreación definitiva del universo de Batman en la que pueden recorrer las calles y sobrevolar los tejados de la totalidad de Gotham City. En este explosivo desenlace, Batman se enfrenta a la mayor amenaza para la ciudad que ha jurado proteger, cuando el Espantapájaros reaparece para unir a todos los supervillanos de Gotham y jura destruir al murciélago de una vez para siempre.","/imagenesJuegos/batmanarkhamknight.jpg","/imagenesJuegos/batmanarkhamknightCap.jpg", genero1, "Rocsteady Studios", reseniaBatman2));
        
        LinkedList<Resena> reseniaBatman3 = new LinkedList<>();
        reseniaBatman3.addLast(new Resena("Enner Valencia",4, LocalDate.of(2018, Month.FEBRUARY, 19),"Aburrido"));
        juegos.addLast(new Juego("Batman Arkham City","Batman: Arkham City está basado en la intensa atmósfera de Batman: Arkham Asylum, llevando a los jugadores a través de la enorme Arkham City (universo cinco veces más grande que el juego de Batman: Arkham Asylum) el nuevo \"hogar\" de máxima seguridad para todos los matones, gangsters y mentes criminales de Gotham City. Con la increíble participación del más peligroso elenco de enemigos de Gotham City como Catwoman, Joker, Enigma, Dos Caras, Harley Quinn, El Pingüino, Mr. Freeze y muchos más, el juego permite a los jugadores una experiencia genuina que les hará sentir como El Caballero Oscuro que reparte justicia en las calles de Gotham City.","/imagenesJuegos/batmanarkhamcity.jpg","/imagenesJuegos/batmanarkhamcityCap.jpg", genero1, "Rocsteady Studios", reseniaBatman3));
        
        LinkedList<Resena> reseniaGodofwar2 = new LinkedList<>();
        reseniaGodofwar2.addLast(new Resena("Jose Luis Ortega",2, LocalDate.of(2022, Month.DECEMBER, 02),"muy malo"));
        juegos.addLast(new Juego("God of War Ragnarok", "Kratos y Atreus deben viajar a cada uno de los nueve reinos en búsqueda de respuestas, mientras que las fuerzas asgardianas se preparan para una batalla profetizada que terminará con el mundo. En el camino explorarán paisajes increíbles y míticos, y se enfrentarán a aterradores enemigos en la forma de dioses nórdicos y monstruos. La amenaza del Ragnarök cada vez está más cerca. Kratos y Atreus deben elegir entre su propia seguridad y la seguridad de los reinos.","/imagenesJuegos/godofwarragnarok.jpg","/imagenesJuegos/godofwarragnarokCap.jpg", genero1,"Santa Monica Studio",reseniaGodofwar2));
        
        LinkedList<String> genero2 = new LinkedList<>();
        genero2.addLast("Acción");genero2.addLast("Disparos");
        
        
        LinkedList<Resena> reseniaFortnite = new LinkedList<>();
        reseniaFortnite.addLast(new Resena("Guillermo Lasso",4, LocalDate.of(2018, Month.DECEMBER, 17),"muy entretenido"));
        juegos.addLast(new Juego("Fortnite", "Reúne a tus amigos y dad el salto a Fortnite, de Epic Games: un enfrentamiento gigante entre 100 jugadores en el que se combinan los disparos, reunir botín, fabricar cosas y el caos absoluto. El resultado es una experiencia competitiva online feroz y totalmente impredecible que cada temporada se vuelve más salvaje.","/imagenesJuegos/fotnite.jpg","/imagenesJuegos/fortniteCap.jpg", genero1,"Epic Games",reseniaFortnite));
        
        LinkedList<Resena> reseniaFreeFire = new LinkedList<>();
        reseniaFreeFire.addLast(new Resena("Guillermo Lasso",2, LocalDate.of(2019, Month.DECEMBER, 23),"pesimo"));
        juegos.addLast(new Juego("Free Fire", "Free Fire es un juego de sobrevivencia mundialmente conocido, disponible en dispositivos móviles. Cada juego de 10 minutos te pondrá en una isla remota con otros 49 jugadores buscando sobrevivir. Los jugadores podrán elegir con libertad su punto de partida usando su paracaídas y deberán mantenerse en la zona segura el mayor tiempo posible. Podrán conducir vehículos para explorar el mapa, crear estrategias para esconderse o usar objetos para camuflaje. Embosca y apunta, sólo hay un objetivo: sobrevivir.","/imagenesJuegos/freefire.jpg","/imagenesJuegos/freefireCap.jpg", genero2,"Garena International",reseniaFreeFire));
        
        LinkedList<String> genero3 = new LinkedList<>();
        genero3.addLast("Deportes");
        
        
        LinkedList<Resena> reseniaFifa21 = new LinkedList<>();
        reseniaFifa21.addLast(new Resena("Guillermo Lasso",2, LocalDate.of(2021, Month.MAY, 3),"nada nuevo"));
        juegos.addLast(new Juego("Fifa 21", "Gana como equipo en EA SPORTS™ FIFA 21, de la mano de Frostbite™. Ya sea que el juego tenga lugar en calles o estadios, FIFA 21 ofrece más formas de jugar que antes, incluidas la Liga de Campeones de la UEFA y la copa CONMEBOL Libertadores.","/imagenesJuegos/fifa21.jpg","/imagenesJuegos/fifa21Cap.jpg", genero3,"Electronic Arts",reseniaFifa21));
        
        LinkedList<Resena> reseniaFifa22 = new LinkedList<>();
        reseniaFifa21.addLast(new Resena("Rafel Correa",4, LocalDate.of(2021, Month.MAY, 24),"innovador"));
        juegos.addLast(new Juego("Fifa 22", "En  EA SPORTS™ FIFA 22,  cada momento en el campo de juego se amplifica con  HyperMotion, una tecnología de juego diseñada para aprovechar la potencia de la PlayStation 5. Con la integración de la captura avanzada de partidos 11v11 y el aprendizaje automático, HyperMotion brinda a FIFA 22 datos de movimiento real en tiempo real provenientes de jugadores profesionales en partidos de alta intensidad para obtener la experiencia de juego más realista, eficaz y fluida en la historia de FIFA. \n" +"\n" +"Los modos de juego clásicos vuelven con una nueva temporada de innovación: Crea tu propio club en el Modo carrera, siente la nostalgia con nuevos héroes de FIFA Ultimate Team y obtén recompensas por tu habilidad en las calles con un estilo de juego distinto en VOLTA FOOTBALL","/imagenesJuegos/fifa22.jpg","/imagenesJuegos/fifa22Cap.jpg", genero3,"Electronic Arts",reseniaFifa22));
        
        LinkedList<String> genero4 = new LinkedList<>();
        genero4.addLast("Acción");genero4.addLast("Estrategia");genero4.addLast("Rol");
        
        LinkedList<Resena> reseniaLol = new LinkedList<>();
        reseniaLol.addLast(new Resena("Rafel Correa",5, LocalDate.of(2016, Month.APRIL, 12),"el mejor juego de todos"));
        juegos.addLast(new Juego("League of Legends", "Convertíos en leyendas, encontrad a vuestro campeón, dominad sus habilidades y superad a vuestros oponentes en una épica batalla 5v5 para destruir la base enemiga.","/imagenesJuegos/lol.jpg","/imagenesJuegos/lolCap.jpg", genero4,"Riot Games",reseniaLol));
        
        
        LinkedList<String> genero5 = new LinkedList<>();
        genero5.addLast("Acción");genero5.addLast("Aventura");
        
        LinkedList<Resena> reseniaMinecraft = new LinkedList<>();
        reseniaLol.addLast(new Resena("Rafael Correa",5, LocalDate.of(2016, Month.APRIL, 12),"el mejor juego de todos"));
        juegos.addLast(new Juego("League of Legends", "Explora mundos generados al azar y construye cosas increíbles, desde las casas más sencillas hasta los castillos más grandiosos. Juega en modo creativo con recursos ilimitados o excava hasta las profundidades del mundo en el modo supervivencia, donde deberás fabricar armas y armaduras para defenderte de las peligrosas criaturas. Escala montañas, explora cuevas complejas y extrae muchas vetas de minerales. Descubre los biomas de cuevas exuberantes y con estalactitas. ¡Ilumina tu mundo con velas para presumir tus habilidades de espeleología y montañismo!","/imagenesJuegos/minecraft.jpg","/imagenesJuegos/minecraftCap.jpg", genero5,"Mojang",reseniaMinecraft));
        
        LinkedList<Resena> reseniaGta = new LinkedList<>();
        reseniaGta.addLast(new Resena("Ricky Martin",5, LocalDate.of(2019, Month.JUNE, 8),"juego espectacuar"));
        juegos.addLast(new Juego("Grand Thef Auto 5", "Cuando un joven estafador callejero, un ladrón de bancos retirado y un psicópata aterrador se ven envueltos con algunos de los elementos más aterradores y trastornados del inframundo criminal, el gobierno de los EE. UU. y la industria del entretenimiento, deben llevar a cabo una serie de peligrosos atracos. sobrevivir en una ciudad despiadada en la que no pueden confiar en nadie, y menos en los demás.","/imagenesJuegos/minecraftgrandtheftauto.jpg","/imagenesJuegos/grandtheftautoCap.jpg", genero5,"Mojang",reseniaGta));
        
        
        return juegos;
        
    }

    @Override
    public String toString() {
        return "Juego{" + "titulo=" + titulo + ", descripcion=" + descripcion + ", imagen=" + imagen + ", captura=" + captura + ", genero=" + genero + ", desarrollador=" + desarrollador + ", Resenia=" + Resenia + '}';
    }
    
    
    
    
    
}
