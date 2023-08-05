package org.mapledpmlab.type.skill.buffskill.hero;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.hero.ComboInstinctsAttack;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ComboInstinctsBuff extends BuffSkill {
    public ComboInstinctsBuff() {
        this.setName("콤보 인스팅트");
        this.setBuffAttMagic(4L);
        this.setBuffDamage(4L);
        this.setBuffFinalDamage(1.2);
        this.setCooldown(120.0);
        this.setDelay(450L);
        this.setDuration(20L);
    }
}
