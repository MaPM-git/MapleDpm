package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SunRiverMountainWindWave1 extends AttackSkill {
    public SunRiverMountainWindWave1() {
        this.setName("해 강 산 바람(충격1)");
        this.setDamage(1850.0);
        this.setAttackCount(10L);
        this.setCooldown(180.0);
        this.setRelatedSkill(new SunRiverMountainWindWave2());
        this.addFinalDamage(1.6);   // 코어강화
        this.getMultiAttackInfo().add(630L + 630);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
    }
}
