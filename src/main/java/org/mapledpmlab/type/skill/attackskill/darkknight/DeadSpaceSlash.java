package org.mapledpmlab.type.skill.attackskill.darkknight;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DeadSpaceSlash extends AttackSkill {
    public DeadSpaceSlash() {
        this.setName("데드 스페이스(참격)");
        this.setAttackCount(6L);
        this.setCooldown(360.0);
        this.setDamage(3600.0);
        this.setDotDuration(5180L);
        this.setInterval(2590L);
        this.setLimitAttackCount(2L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new DeadSpaceSlashDelay());
    }
}
