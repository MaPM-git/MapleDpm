package org.mapledpmlab.type.skill.attackskill.khali;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ArtsFlurry extends AttackSkill implements ArtsSkill {
    public ArtsFlurry() {
        this.setName("아츠 : 플러리");
        this.setDamage(585.0);
        this.setAttackCount(7L + 1);
        //this.setDelay(150L);
        this.setDelayByAttackSpeed(720L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L);     // 아츠-리인포스
    }
}
