package org.mapledpmlab.type.skill.attackskill.khali;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ArtsAstraFinish extends AttackSkill implements ArtsSkill {
    public ArtsAstraFinish() {
        this.setName("아츠 : 아스트라(막타)");
        this.setDamage(880.0);
        this.setAttackCount(8L + 1);
        this.addFinalDamage(1.6);   // 코어강화
        this.setAddDamage(20L);     // 아츠-리인포스
        this.getMultiAttackInfo().add(840L * 3 + 600);
    }
}
