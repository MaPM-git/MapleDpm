package org.mapledpmlab.type.skill.buffskill.ark;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SpecterForm extends BuffSkill {
    public SpecterForm() {
        this.setName("스펙터 잠식");
        //this.setDelay(720L);
        //this.setDuration(300L);
        //this.addBuffAttMagic(30L);
    }
}
