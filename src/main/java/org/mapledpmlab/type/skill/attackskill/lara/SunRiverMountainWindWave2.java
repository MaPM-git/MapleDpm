package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SunRiverMountainWindWave2 extends AttackSkill {
    public SunRiverMountainWindWave2() {
        this.setName("해 강 산 바람(충격2)");
        this.setDamage(2310.0);
        this.setAttackCount(10L);
        this.addFinalDamage(1.6);   // 코어강화
        this.addFinalDamage(1.08);      // 오버로드 마나
        this.setRelatedSkill(new SunRiverMountainWindWave3());
        this.getMultiAttackInfo().add(1560L + 30);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
    }
}
