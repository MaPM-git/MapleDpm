package org.mapledpmlab.type.skill.buffskill.dualblade;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.dualblade.Flashbang;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class FlashbangBuff extends BuffSkill {
    public FlashbangBuff() {
        this.setName("플래시 뱅");
        this.setCooldown(60.0);
        this.setDuration(60L);
        this.addBuffDamage(10L);
        this.setRelatedSkill(new Flashbang());
    }
}
