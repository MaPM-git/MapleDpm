package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.bishop.PeacemakerBuff;

public class PeacemakerFinish extends AttackSkill {
    public PeacemakerFinish() {
        this.setName("피스메이커(신성한 빛)");
        this.setDamage(770.0);
        this.setAttackCount(12L);
        this.setRelatedSkill(new PeacemakerBuff());
        this.addFinalDamage(1.6);       // 코어강화
    }
}
