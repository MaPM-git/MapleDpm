package org.mapledpmlab.type.skill.attackskill.hero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.hero.IncisingBuff;

public class IncisingAttack extends AttackSkill {
    public IncisingAttack() {
        this.setName("인사이징");
        this.setAttackCount(4L);
        this.setDamage(640.0);
        this.setDelayByAttackSpeed(870L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.setRelatedSkill(new IncisingDot());
    }
}
