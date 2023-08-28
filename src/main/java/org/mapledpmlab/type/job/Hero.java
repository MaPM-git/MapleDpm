package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossCriticalAbnormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.farm.FinalAttackFarm;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.StrUnion;

import java.util.stream.Collectors;

public class Hero extends Job {

    public Hero() {
        // 기본
        super();
        this.setName("히어로");
        this.setConstant(1.44);         // 무기상수
        this.setMastery(1.9 / 2);       // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION2);

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addAtt((long) (340 + 210 + 72 + 253));
        this.setWeaponAttMagic((long) (340 + 210 + 72 + 253));
        this.addBossDamage((long) (30 + 10));
        this.addIgnoreDefenseList(20L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);
        this.addAttP(3L);

        // 보조
        this.addMainStat(10L);
        this.addSubStat(10L);
        this.addAtt(3L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);

        // 2차
        this.addAtt(30L);               // 스피릿 블레이드
        this.addFinalDamage(1.1);       // 웨폰 마스터리
        this.addMainStat(20L);          // 웨폰 액셀레이션
        this.addMainStat(30L);          // 피지컬 트레이닝
        this.addSubStat(30L);

        // 3차
        this.addCriticalP(20.0);        // 찬스 어택
        this.addStatXFinalDamage(1.25);

        // 4차
        this.addCriticalDamage(20.0);   // 인레이지
        this.addFinalDamage(1.25);
        this.addFinalDamage(2.3);       // 어드밴스드 콤보(하이퍼 포함)
        this.addBossDamage(20L);
        this.addIgnoreDefenseList(51L);  // 컴뱃 마스터리
        this.addAtt(31L);               // 어드밴스드 파이널 어택

        // 5차
        this.addMainStat(30L);          // 바디 오브 스틸

        this.setAbility(new BossCriticalAbnormal());
        this.setFarm(new FinalAttackFarm());
        this.getLinkList().add(new PhantomInstinct());
        this.setUnion(new StrUnion());
        this.addPerXMainStat(20L);

        this.addObject(this.getAbility());
        this.addObject(this.getFarm());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }

    @Override
    public void Doping() {
        super.Doping();
        this.addDamage(25L);            // 인사이징
    }
}
