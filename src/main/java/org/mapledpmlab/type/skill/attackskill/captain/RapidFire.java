package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RapidFire extends AttackSkill {
    public RapidFire() {
        this.setName("래피드 파이어");
        this.setAttackCount(1L);
        this.setDamage(555.0);
        this.setDelay(120L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(30L + 20);    // 래피트 파이어-리인포스, 보스 킬러
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
