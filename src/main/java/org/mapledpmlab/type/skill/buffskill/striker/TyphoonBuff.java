package org.mapledpmlab.type.skill.buffskill.striker;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class TyphoonBuff extends BuffSkill {
    public TyphoonBuff() {
        this.setName("태풍");
        this.setDuration(91L);
        this.addBuffDamage(15L);
    }
}
