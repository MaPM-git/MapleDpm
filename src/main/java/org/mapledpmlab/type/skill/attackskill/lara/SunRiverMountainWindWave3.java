package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SunRiverMountainWindWave3 extends AttackSkill {
    public SunRiverMountainWindWave3() {
        this.setName("해 강 산 바람(충격3)");
        this.setDamage(1850.0);
        this.setAttackCount(10L);
        this.addFinalDamage(1.6);   // 코어강화
        this.addFinalDamage(1.08);      // 오버로드 마나
        this.setRelatedSkill(new SunRiverMountainWindWave4());
        this.getMultiAttackInfo().add(2250L + 30);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
    }
}
