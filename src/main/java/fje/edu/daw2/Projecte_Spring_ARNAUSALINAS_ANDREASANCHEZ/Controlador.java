package fje.edu.daw2.Projecte_Spring_ARNAUSALINAS_ANDREASANCHEZ;

import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"totalPrevisions" , "veurePrevisions"})
public class Controlador {

    ArrayList<Previsio> totalPrevisions = new ArrayList<>();
    ArrayList<Previsio> veurePrevisions = new ArrayList<>();

    @Autowired
    private static MongoDBRepositori bbddMongoDB;

    @ModelAttribute("previsions")
    public List<Previsio> inicialitzar() {

        for (Previsio c : bbddMongoDB.findAll()) {
            totalPrevisions.add(c);
        }
        return totalPrevisions;
    }

    @GetMapping("/veureCRUD")
    public String veureCRUD(
            @RequestParam(defaultValue = "0", required = false) String ciutat,
            Model model) {

        veurePrevisions.clear();

        for(int i = 0; i < totalPrevisions.size(); i++){
            if(totalPrevisions.get(i).getCiutat().equals(ciutat)){
                veurePrevisions.add(totalPrevisions.get(i));
            }
        }

        model.addAttribute("previsions", veurePrevisions);
        model.addAttribute("ciutat", ciutat);

        return "CRUDPrevisions";
    }

    @GetMapping("/veurePrevisio")
    public String veurePrevisio(
            @RequestParam(defaultValue = "0", required = false) String ciutat,
            Model model) {

        veurePrevisions.clear();

        for(int i = 0; i < totalPrevisions.size(); i++){
            if(totalPrevisions.get(i).getCiutat().equals(ciutat)){
                veurePrevisions.add(totalPrevisions.get(i));
            }
        }

        model.addAttribute("previsions", veurePrevisions);
        model.addAttribute("ciutat", ciutat);

        return "veurePrevisions";
    }

    @GetMapping("/insertar")
    public String insertar(
            @RequestParam(defaultValue = "0", required = false) String dia, float temperatura, String icona, String ciutat,
            Model model) {

        int id = 1;
        if(totalPrevisions.size() != 0){
            for(int i = 0; i < totalPrevisions.size(); i++){
                id++;
            }
        }

        Previsio previsio = new Previsio(id, temperatura, icona, ciutat, dia);
        totalPrevisions.add(previsio);

        model.addAttribute("previsions", veurePrevisions);
        model.addAttribute("ciutat", ciutat);

        veurePrevisions.clear();

        for(int i = 0; i < totalPrevisions.size(); i++){
            if(totalPrevisions.get(i).getCiutat().equals(ciutat)){
                veurePrevisions.add(totalPrevisions.get(i));
            }
        }

        return "CRUDPrevisions";
    }

    @GetMapping("/modificar")
    public String modificar(
            @RequestParam(defaultValue = "0", required = false) String dia, float temperatura, String icona, String ciutat,
            Model model) {

        if(totalPrevisions.size() != 0){
            int i;
            for(i = 0; i < totalPrevisions.size(); i++){
                if(totalPrevisions.get(i).getCiutat().equals(ciutat) && totalPrevisions.get(i).getDia().equals(dia)){
                    totalPrevisions.remove(i);
                    break;
                }
            }
        }

        System.out.println();

        int id = 1;
        if(totalPrevisions.size() != 0){
            for(int i = 0; i < totalPrevisions.size(); i++){
                id++;
            }
        }
        Previsio previsio = new Previsio(id, temperatura, icona, ciutat, dia);
        totalPrevisions.add(previsio);

        veurePrevisions.clear();

        for(int i = 0; i < totalPrevisions.size(); i++){
            if(totalPrevisions.get(i).getCiutat().equals(ciutat)) {
                veurePrevisions.add(totalPrevisions.get(i));
            }
        }

        model.addAttribute("previsions", veurePrevisions);
        model.addAttribute("ciutat", ciutat);

        return "CRUDPrevisions";
    }

    @GetMapping("/eliminar")
    public String eliminar(
            @RequestParam(defaultValue = "0", required = false) String dia, String ciutat,
            Model model) {

        if(totalPrevisions.size() != 0){
            int i;
            for(i = 0; i < totalPrevisions.size(); i++){
                if(totalPrevisions.get(i).getCiutat().equals(ciutat) && totalPrevisions.get(i).getDia().equals(dia)){
                    totalPrevisions.remove(i);
                    break;
                }
            }
        }

        veurePrevisions.clear();

        for(int i = 0; i < totalPrevisions.size(); i++){
            if(totalPrevisions.get(i).getCiutat().equals(ciutat)) {
                veurePrevisions.add(totalPrevisions.get(i));
            }
        }

        model.addAttribute("previsions", veurePrevisions);
        model.addAttribute("ciutat", ciutat);

        return "CRUDPrevisions";
    }

    @GetMapping("/insertarView")
    public String insertarView(
            @RequestParam(defaultValue = "0", required = false) String ciutat,
            Model model) {

        model.addAttribute("ciutat", ciutat);

        return "insertarPrevisio";
    }

    @GetMapping("/modificarView")
    public String modificarView(
            @RequestParam(defaultValue = "0", required = false) String dia, String ciutat,
            Model model) {

        model.addAttribute("ciutat", ciutat);
        model.addAttribute("dia", dia);

        return "modificarPrevisio";
    }


}
