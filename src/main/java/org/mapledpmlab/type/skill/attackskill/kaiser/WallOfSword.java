package org.mapledpmlab.type.skill.attackskill.kaiser;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WallOfSword extends AttackSkill {
    public WallOfSword() {
        this.setName("윌 오브 소드");
        this.setDamage(775.0);
        this.setAttackCount(4L);
        this.setCooldown(10.0);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(1500L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.setApplyReuse(true);
    }
}
