package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossBuffReuse;
import org.mapledpmlab.type.ability.ReuseBossBuff;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.StrUnion;

import java.util.stream.Collectors;

public class Kaiser2 extends Job {

    public Kaiser2() {
        // 기본
        super();
        this.setName("카이저(2초, 리레단일)");
        this.setConstant(1.34);         // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION2);

        this.setAscentDamage(3112200.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addAtt((long) (340 + 210 + 72 + 253));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        passive.addAttP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (340 + 210 + 72 + 253));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat(10L);
        passive.addSubStat(10L);
        passive.addOtherStat1(10L);
        passive.addOtherStat2(10L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        getPassiveList().add(passive);

        // 0차
        passive = new Common();
        passive.setDescription("리셔플스위치 : 공격모드");
        passive.addAtt(5L);
        passive.addCriticalP(3.0);
        passive.addBossDamage(3L);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("블레이즈 업");
        passive.addAtt(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("이너 블레이즈");
        passive.addMainStat(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("공격모드 1차 강화");
        passive.addAtt(10L);
        passive.addCriticalP(2.0);
        passive.addBossDamage(5L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("카탈라이즈");
        passive.addAttP(30L);
        passive.addCriticalP(20.0);
        passive.addFinalDamage(1.32);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("어드밴스드 이너 블레이즈");
        passive.addMainStat(30L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("공격모드 2차 강화");
        passive.addAtt(15L);
        passive.addCriticalP(5.0);
        passive.addBossDamage(5L);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("어드밴스드 윌 오브 소드");
        passive.addAtt(22L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("언플리칭 커리지");
        passive.addIgnoreDefenseList(41L);
        passive.addCriticalDamage(7.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("어드밴스드 소드 마스터리");
        passive.addAtt(31L);
        passive.addCriticalP(20.0);
        passive.addCriticalDamage(15.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("공격모드 3차 강화");
        passive.addAtt(15L);
        passive.addCriticalP(10.0);
        passive.addBossDamage(5L);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("바디 오브 스틸");
        passive.addMainStat(30L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(-93L);
        this.addMainStat(3L);
        this.addSubStat(5L);

        this.setAbility(new ReuseBossBuff());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
        this.setUnion(new StrUnion());
        this.addPerXMainStat(20L);

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }

    @Override
    public void Doping() {
        super.Doping();

        Common doping = new Common();
        doping.setDescription("어드밴스드 소드 마스터리(콜렉터의 영약)");
        doping.addAtt(1L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }
}
