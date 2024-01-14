package org.mapledpmlab.type.skill.attackskill.darkknight;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DeadSpaceDarkAura extends AttackSkill {
    public DeadSpaceDarkAura() {
        this.setName("데드 스페이스(어둠의 기운)");
        this.setAttackCount(14L);
        this.setDamage(6000.0);
        this.setDotDuration(1000L);
        this.setInterval(100L);
        this.setLimitAttackCount(10L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new DeadSpaceDarkAuraDelay());
    }
}
