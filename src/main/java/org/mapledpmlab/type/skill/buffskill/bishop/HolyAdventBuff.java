package org.mapledpmlab.type.skill.buffskill.bishop;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.bishop.HolyAdventBalance;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class HolyAdventBuff extends BuffSkill {
    public HolyAdventBuff() {
        this.setName("홀리 어드밴트(버프)");
        this.setCooldown(360.0);
        this.setDuration(60L);
        this.addBuffFinalDamage(1.05);
        this.setRelatedSkill(new HolyAdventBalance());
    }
}
