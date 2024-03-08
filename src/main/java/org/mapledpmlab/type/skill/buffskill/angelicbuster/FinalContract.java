package org.mapledpmlab.type.skill.buffskill.angelicbuster;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class FinalContract extends BuffSkill {
    public FinalContract() {
        this.setName("파이널 컨트랙트");
        this.setDelay(630L);
        this.setBuffDamage(10L + 20);
        this.setCooldown(120.0);
        this.setDuration(30L);
        this.addBuffAttMagic(50L);
        this.addBuffIgnoreDefense(30L);
    }
}
