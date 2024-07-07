package org.mapledpmlab.type.skill.attackskill.darkknight;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DeadSpaceSlash extends AttackSkill {
    public DeadSpaceSlash() {
        this.setName("데드 스페이스(참격)");
        this.setAttackCount(6L);
        this.setCooldown(360.0);
        this.setDamage(1200.0);
        this.setRelatedSkill(new DeadSpaceDarkAura());
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(50L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
    }
}
