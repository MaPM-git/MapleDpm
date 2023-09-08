package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SongOfHeaven extends AttackSkill {
    public SongOfHeaven() {
        this.setName("천공의 노래");
        this.setAttackCount(1L);
        this.setDamage(960.0);
        this.setDelay(120L);
        this.setAddDamage(20L + 30);    // 천공의 노래-리인포스, 보스 킬러
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
