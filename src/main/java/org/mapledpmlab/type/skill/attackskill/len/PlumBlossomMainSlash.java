package org.mapledpmlab.type.skill.attackskill.len;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PlumBlossomMainSlash extends AttackSkill {
    public PlumBlossomMainSlash() {
        this.setName("매화검 본초 : 선참");
        this.setDelay(150L);
        this.setAttackCount(5L);
        this.setDamage(289.0);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(20L + 20);        // 매화검 본초 : 선참-리인포스, 보스 킬러
        this.addIgnoreDefenseList(20L);     // 매화검 본초 : 선참-이그노어 가드
    }
}
