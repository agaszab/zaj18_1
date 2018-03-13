package pl.javastart.zaj18_1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AnimalsController {

    List<Cat> animals=new ArrayList<>();

    public AnimalsController() {
        Cat ct1 = new Cat ("Franek", 3," Franek trafił do schroniska w marcu 2015 roku po wypadku. Znaleziony został na ulicy Modrej i raczej nie był kotem domowym, dlatego nie przepadał za ludzkim towarzystwem. Z innymi kotami dogadał się bez problemu i akceptuje ich obecność.  Od pewnego czasu kocur - bo jest on kotem sporych rozmiarów przekonał się do kontaktu z człowiekiem i bardzo polubił głaskanie po głowie. Wypatruje człowieka i widać, że mu go brakuje. Traf spędził w schronisku już prawie dwa lata, więc tym bardziej potrzebuje domu, żeby zobaczyć jak może wyglądać życie z własnym opiekunem. Na początku na pewno będzie potrzebował trochę czasu na adaptację w zupełnie dla niego nowym świecie - jednak skoro u nas przekonał się w końcu do ludzi, tymbardziej w domu uda nawiązac się z nim kontakt. Dla Trafa i jego właściciela wspólne życie będzie radością z odkrywania nowych aspektów kocio - ludzkiej relacji.  ", "Franek.jpg");
        Cat ct2 = new Cat ("Miluś", 6,"Gdy trafił do Schroniska, nie ufał ludziom, nie pozwalał się głaskać. Był prawdopodbnie kotem 'piwnicznym', który wcześniej nie miał zbyt wiele kontakltu z ludźmi. Na szczęście pozwolił się 'przekonać' i widać, że głaskanie sprawia mu przyjemnośćź. Uwielbia drapanie pod brodą, polubił towarzystwo ludzi. Inne koty traktuje obojętnie. Wbrew pozorem nie tęskni za 'wolnością', owszem lubi oglądać świat przez okno, ale do kociej woliery na zewnątrz nigdy nie wychodzi. Musiał nie mieć zbyt łatwego życia wcześniej, takie koty po początkowym stresie przy zmianie miejsca na nowy dom najczęściej aklimatyzują się bardzo szybko i 'doceniają' nowe wygodne życie ;) \n" +
                "MIluś potrzebuje cierpliwych i spokojnych opiekunów. ", "Miluś.jpg");
        Cat ct3 = new Cat ("Oskar", 1," Oskar to piękny kocur, który trafił do Schroniska w kwietniu 2016 po wypadku. Niestety skutki obrażeń spowodowały, że teraz ma bardzo małe szanse na dom. Sam nie oddaje moczu - trzeba go 'odsikiwać' (3 razy dziennie) utyka na tylną łapę. Na szczęście jest bardzo inteligentnym kotem i pomimo, że na początku udzielenie mu pomocy było bardzo trudne (był to dziki kot) dość szybko zrozumiał, że ludzie mu pomagają. Przy odrobinie ćwiczeń 'odsikanie' go nie sprawia problemów i wystarczy poświęcić 3 minutki 3 razy dziennie/ \n" +
                "Oskar przeszedł ogromną przemianę jeśli chodzi o stosunek do ludzi, teraz sam przychodzi na głaskanie, domaga się go. Lubi być noszony na rękach. Jest tak towarzyski, że nawet grupa głaszczących go przedszkolaków nie jest mu straszna ;) Polubił wygodne domowe życie, a ze względu na obrażenia powypadkowe nie może być kotem wychodzącym (chyba, że dom z wysokim ogrodzeniem, którego Oskar nie pokona ).    Adopcja Oskara nie jest sprawą łatwą, zabranie  go do domu wiąże się z dodatkowym obciążeniem i pewnymi niedogodnościami, których nie ma przy 'normalnych' kotach. Dlatego zrozumiałe jest to, że większość osób rezygnuje z adopcji, prosimy jednak o udostępnianie informacji o Oskarze. Gdzieś na pewno czeka na niego dom, tylko trzeba mu pomóc do niego trafić. W razie jakichkolwiek pytań o opiekę jakiej potrzebuje oczywiście chętnie odpowiemy.  PS Już raz był adoptowany, jednak został zwrócony z powodu agresji w stosunku do drugiego kota w domu. Jednak wielomiesięczna obserwacja go pod tym kątem w Schronisku daje zupełnie inne wyniki - innym kotom schodzi z drogi, nawet przy człowieku z zazdrości nie atakuje innych kotów.  Oskar, jest wyjątkowym kotem, warto go poznać i rozważyć przyjęcie go do domu.", "Oskar.jpg");
        animals.add(ct1);
        animals.add(ct2);
        animals.add(ct3);
    }



    @RequestMapping("/")
    public String cats(Model model) {
        model.addAttribute("koty", animals);
        return "index"; // nazwa pliku html
    }

 /*   @RequestMapping("/zwierzaki")
    public String cats(Model model) {
        model.addAttribute("koty", animals);
        return "zwierzaki"; // nazwa pliku html
    } */

    @GetMapping("/kot")
    public String cat (Model model, @RequestParam String name) {

        for(Cat kot: animals) {
           if (name.equals(kot.getName())) {
               int age=kot.getAge();
               String opis=kot.getText();
               String img=kot.getImg();

               model.addAttribute("imie", name);
               model.addAttribute("wiek", age);
               model.addAttribute("opis", opis);
               model.addAttribute("img", img);

           }
        }

      /*     for (int i = 0; i < animals.size(); i++) {

            if (name.equals(animals.get(i).getName()) )  {
                int age=animals.get(i).getAge();
                String opis=animals.get(i).getText();
                String img=animals.get(i).getImg();

                model.addAttribute("imie", name);
                model.addAttribute("wiek", age);
                model.addAttribute("opis", opis);
                model.addAttribute("img", img);
            }

        } */

        return "kot"; // nazwa pliku html

    }

    @GetMapping ("/dodaj")
    public String addForm (Model model) {
        model.addAttribute("newCat" , new Cat());
        return "formularz";
    }


    @PostMapping("/add")
    public String add( Cat cat) {
        animals.add(cat);
        return "redirect:/";
    }


}
