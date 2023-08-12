package org.mapledpmlab.type.skill.buffskill.dualblade;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.dualblade.FinalCut;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class FinalCutBuff extends BuffSkill {
    public FinalCutBuff() {
        this.setName("파이널 컷");
        this.setCooldown(110.0);
        this.setDuration(114L);
        this.addBuffFinalDamage(1.4);
        this.setRelatedSkill(new FinalCut());
    }
}
