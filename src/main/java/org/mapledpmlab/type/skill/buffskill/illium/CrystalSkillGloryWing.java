package org.mapledpmlab.type.skill.buffskill.illium;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class CrystalSkillGloryWing extends BuffSkill {
    public CrystalSkillGloryWing() {
        this.setName("크리스탈 스킬:글로리 윙");
        this.setDelay(30L);
        this.addBuffFinalDamage(1.25);
        this.addBuffDamage(30L);
        this.setDuration(20L);
    }
}
