package org.mapledpmlab.type.skill.buffskill.ark;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ContactCaravan extends BuffSkill {
    public ContactCaravan() {
        this.setName("컨택트 카라반(바크바크)");
        this.setDelay(720L);
        this.setCooldown(600.0);
        this.setDuration(300L);
        this.addBuffDamage(8L);
        this.setApplyServerLag(true);
    }
}
