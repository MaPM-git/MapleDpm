package org.mapledpmlab.type.skill.attackskill.bowmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HurricaneSpree extends AttackSkill {
    public HurricaneSpree() {
        this.setName("폭풍의 시(난사 모드)");
        this.setAttackCount(2L);        // 폭풍의 시-스플릿 어택
        this.addFinalDamage(0.75);
        this.setDamage(750.0);
        this.setDelay(90L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(30L + 10);    // 폭풍의 시-리인포스, 보스 킬러
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
