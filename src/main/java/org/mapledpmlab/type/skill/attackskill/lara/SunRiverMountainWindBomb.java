package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SunRiverMountainWindBomb extends AttackSkill {
    public SunRiverMountainWindBomb() {
        this.setName("해 강 산 바람(폭발)");
        this.setDamage(2245.0);
        this.setAttackCount(15L);
        this.setDelay(840L);
        this.addFinalDamage(1.6);   // 코어강화
        this.getMultiAttackInfo().add(5850L + 30);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
    }
}
