package org.mapledpmlab.type.skill.buffskill.phantom;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.phantom.FinalCut;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class FinalCutBuff extends BuffSkill {
    public FinalCutBuff() {
        this.setName("파이널 컷");
        this.setCooldown(88.0);
        this.setDuration(60L);
        this.addBuffFinalDamage(1.41);
        this.setApplyPlusBuffDuration(true);
        this.setRelatedSkill(new FinalCut());
    }
}
