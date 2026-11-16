package main.lld.creational.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
public class RecipientList {
    private List<String> to;
    private List<String> cc;

    RecipientList deepCopy(){
        return new RecipientList(new ArrayList<>(to), new ArrayList<>(cc));
    }
    public void addTo(String to){
        this.to.add(to);
    }
    public void addCc(String cc){
        this.cc.add(cc);
    }
}
