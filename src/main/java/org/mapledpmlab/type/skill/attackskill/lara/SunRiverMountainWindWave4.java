package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SunRiverMountainWindWave4 extends AttackSkill {
    public SunRiverMountainWindWave4() {
        this.setName("해 강 산 바람(충격4)");
        this.setDamage(2310.0);
        this.setAttackCount(10L);
        this.addFinalDamage(1.6);   // 코어강화
        this.addFinalDamage(1.08);      // 오버로드 마나
        this.setRelatedSkill(new SunRiverMountainWindBomb());
        this.getMultiAttackInfo().add(3150L + 30);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
    }
}
